package es.openbank.remote.error

import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonEncodingException
import es.openbank.model.error.ErrorResult
import es.openbank.model.error.RemoteRequestException
import retrofit2.HttpException
import java.net.UnknownHostException

object RemoteErrorRequestExecutor {

    inline fun <T> execute(block: () -> T): T {
        return try {
            block()
        } catch (e: Throwable) {
            throw RemoteRequestException(processError(e))
        }
    }

    fun processError(throwable: Throwable): ErrorResult {
        return when(throwable) {
            is HttpException -> processRetrofitError(throwable)
            is UnknownHostException -> ErrorResult.ConnectionError(throwable.message ?: "Error de conexión con el host")
            is JsonDataException,
            is JsonEncodingException -> ErrorResult.DataParseError(throwable.message ?: "Error de parseo del JSON")
            else -> ErrorResult.UnknownError(throwable.message ?: "Error desconocido", throwable)
        }
    }

    private fun processRetrofitError(httpException: HttpException): ErrorResult {
        val errorCode = httpException.code()
        val url = httpException.response()?.raw()?.request?.url?.toString() ?: ""
        return ErrorResult.ServerError(errorCode, url)
    }
}