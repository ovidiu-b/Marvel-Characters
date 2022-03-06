package es.openbank.repository.util

import es.openbank.common.wrappers.AsyncResult
import es.openbank.common.wrappers.ErrorResult

interface RepositoryResponse<T> {

    companion object {
        fun <T> onSuccess(getData: () -> T): RepositoryResponse<T> {
            return object : RepositoryResponse<T> {
                override fun getResult(): AsyncResult<T> {
                    return AsyncResult.SUCCESS(getData())
                }
            }
        }

        fun <T> onError(getError: () -> ErrorResult): RepositoryResponse<T> {
            return object : RepositoryResponse<T> {
                override fun getResult(): AsyncResult<T> {
                    return AsyncResult.ERROR(getError())
                }
            }
        }
    }

    fun getResult(): AsyncResult<T>

}