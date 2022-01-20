package es.openbank.repository.util

import es.openbank.model.error.ErrorResult
import es.openbank.model.error.RemoteRequestException

abstract class CacheableRemoteResponse<ResultType> {

    suspend fun execute(): RepositoryResponse<ResultType> {
        val result = try {
            val localResult = loadFromLocal()

            if (localResult == null || shouldRequestFromRemote(localResult)) {
                requestRemoteCall().run {
                    saveRemoteResponse(this)
                    AsyncResult.success(this)
                }
            } else {
                AsyncResult.success(localResult)
            }
        } catch (e: Exception) {
            val asyncError = (e as? RemoteRequestException)?.errorResponse
                ?: ErrorResult.UnknownError("Ha ocurrido un error inesperado", e)
            AsyncResult.error(asyncError)
        }

        return object : RepositoryResponse<ResultType> {
            override fun getResult(): AsyncResult<ResultType> {
                return result
            }
        }
    }

    abstract suspend fun loadFromLocal(): ResultType?

    abstract fun shouldRequestFromRemote(localResponse: ResultType): Boolean

    abstract suspend fun requestRemoteCall(): ResultType

    abstract suspend fun saveRemoteResponse(remoteResponse: ResultType)

}