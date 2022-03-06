package es.openbank.repository.util

import es.openbank.common.wrappers.AsyncResult
import es.openbank.common.wrappers.ErrorResult
import es.openbank.common.wrappers.ErrorResultException

abstract class CacheableRemoteResponse<ResultType> {

    suspend fun execute(): RepositoryResponse<ResultType> {
        val result = try {
            val localResult = loadFromLocal()

            if (localResult == null || shouldRequestFromRemote(localResult)) {
                requestRemoteCall().run {
                    saveRemoteResponse(this)
                    AsyncResult.SUCCESS(this)
                }
            } else {
                AsyncResult.SUCCESS(localResult)
            }
        } catch (e: Throwable) {
            val asyncError = (e as? ErrorResultException)?.errorResult ?: ErrorResult.UnknownError
            AsyncResult.ERROR(asyncError)
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