package es.openbank.repository.util

import es.openbank.common.wrappers.AsyncResult
import es.openbank.common.wrappers.ErrorResult
import es.openbank.common.wrappers.ErrorResultException

abstract class AsyncResultResponse<ResultType> {

    suspend fun execute(): RepositoryResponse<ResultType> {
        val result = try {
            AsyncResult.SUCCESS(performOperation())
        } catch (e: Throwable) {
            AsyncResult.ERROR((e as? ErrorResultException)?.errorResult ?: ErrorResult.UnknownError)
        }

        return object : RepositoryResponse<ResultType> {
            override fun getResult(): AsyncResult<ResultType> {
                return result
            }
        }
    }

    protected abstract suspend fun performOperation(): ResultType

}