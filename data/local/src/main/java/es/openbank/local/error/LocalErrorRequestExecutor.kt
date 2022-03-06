package es.openbank.local.error

import android.database.sqlite.SQLiteException
import es.openbank.common.wrappers.ErrorRequestExecutor
import es.openbank.common.wrappers.ErrorResult

object LocalErrorRequestExecutor: ErrorRequestExecutor() {
    override fun processError(throwable: Throwable, desiredErrorResult: ErrorResult?): ErrorResult {
        desiredErrorResult?.let {
            if (throwable is SQLiteException) return desiredErrorResult
        }

        return ErrorResult.UnknownError
    }

}