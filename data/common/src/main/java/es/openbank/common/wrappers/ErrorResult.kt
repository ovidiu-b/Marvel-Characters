package es.openbank.common.wrappers

sealed class ErrorResult {
    object InsertError : ErrorResult()
    object DeleteError : ErrorResult()
    object ParseJsonError: ErrorResult()
    object ConnectionError : ErrorResult()
    object NotFoundError: ErrorResult()
    object NoInternetConnectionError : ErrorResult()
    object DataBaseError: ErrorResult()
    class ServerError(httpCode: Int) : ErrorResult()
    object UnknownError : ErrorResult()
}