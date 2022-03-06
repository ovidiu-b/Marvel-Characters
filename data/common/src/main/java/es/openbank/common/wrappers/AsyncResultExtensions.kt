package es.openbank.common.wrappers

fun <T> AsyncResult<T>?.isLoading(): Boolean {
    return this != null && this is AsyncResult.LOADING
}

fun <T> AsyncResult<T>?.isSuccess(): Boolean {
    return this != null && this is AsyncResult.SUCCESS
}

fun <T> AsyncResult<T>?.isError(): Boolean {
    return this != null && this is AsyncResult.ERROR
}