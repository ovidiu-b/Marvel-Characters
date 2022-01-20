package es.openbank.remote

interface ApiKeyConfigContract {
    fun getPublicKey(): String
    fun getHash(timeStamp: String): String
}