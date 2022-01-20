package es.openbank.repository.util

import es.openbank.model.error.ErrorResult
import es.openbank.model.error.RemoteRequestException

abstract class RemoteResponse<ResultType> {

    suspend fun execute(): RepositoryResponse<ResultType> {
        val result = try {
            AsyncResult.success(requestRemoteCall())
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

    protected abstract suspend fun requestRemoteCall(): ResultType

}