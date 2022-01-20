package es.openbank.repository.util

import es.openbank.model.error.ErrorResult

data class AsyncResult<out T>(val status: Status, val data: T?, val error: ErrorResult?) {

    companion object {
        fun <T> success(data: T?): AsyncResult<T> {
            return AsyncResult(Status.SUCCESS, data, null)
        }

        fun <T> error(error: ErrorResult?): AsyncResult<T> {
            return AsyncResult(Status.ERROR, null, error)
        }

        fun <T> loading(): AsyncResult<T> {
            return AsyncResult(Status.LOADING, null, null)
        }
    }

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

}