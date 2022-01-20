package es.openbank.model.error

class RemoteRequestException(val errorResponse: ErrorResult): Exception() {
    override fun toString(): String {
        return errorResponse.toString()
    }
}