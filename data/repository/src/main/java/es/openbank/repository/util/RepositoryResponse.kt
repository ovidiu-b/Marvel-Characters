package es.openbank.repository.util

interface RepositoryResponse<Type> {

    fun getResult(): AsyncResult<Type>

}