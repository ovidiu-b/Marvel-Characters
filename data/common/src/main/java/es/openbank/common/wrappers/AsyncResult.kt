package es.openbank.common.wrappers

sealed class AsyncResult<out T>(val data: T?, val error: ErrorResult?) {
    class SUCCESS<out T>(data: T?): AsyncResult<T>(data, null)
    class ERROR(error: ErrorResult?): AsyncResult<Nothing>(null, error)
    class LOADING: AsyncResult<Nothing>(null, null)
}
