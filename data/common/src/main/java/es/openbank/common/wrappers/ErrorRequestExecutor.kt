package es.openbank.common.wrappers

abstract class ErrorRequestExecutor {

    inline fun <T> execute(errorResult: ErrorResult? = null, block: () -> T): T {
        return try {
            block()
        } catch (e: Throwable) {
            throw ErrorResultException(processError(e, errorResult))
        }
    }

    abstract fun processError(throwable: Throwable, desiredErrorResult: ErrorResult?): ErrorResult

}