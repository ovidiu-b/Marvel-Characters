package es.openbank.remote.error

import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonEncodingException
import es.openbank.common.wrappers.ErrorRequestExecutor
import es.openbank.common.wrappers.ErrorResult
import retrofit2.HttpException
import java.net.UnknownHostException

object RemoteErrorRequestExecutor: ErrorRequestExecutor() {

    override fun processError(throwable: Throwable, desiredErrorResult: ErrorResult?): ErrorResult {
        desiredErrorResult?.let { return desiredErrorResult }

        return when(throwable) {
            is HttpException -> ErrorResult.ServerError(throwable.code())
            is UnknownHostException -> ErrorResult.ConnectionError
            is JsonDataException, is JsonEncodingException -> ErrorResult.ParseJsonError
            else -> ErrorResult.UnknownError
        }
    }


}