package es.openbank.model.error

sealed class ErrorResult(val message: String) {
    class ConnectionError(message: String) : ErrorResult(message)
    class DataParseError(message: String) : ErrorResult(message)
    class ServerError(val code: Int, message: String) : ErrorResult(message)
    class UnknownError(message: String, val throwable: Throwable) : ErrorResult(message)
    class CustomError(message: String) : ErrorResult(message)
}