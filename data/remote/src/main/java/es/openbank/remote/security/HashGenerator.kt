package es.openbank.remote.security

interface HashGenerator {
    fun generateHash(password: String): String
}