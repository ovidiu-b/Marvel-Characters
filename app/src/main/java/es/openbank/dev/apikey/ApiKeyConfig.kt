package es.openbank.dev.apikey

import es.openbank.dev.BuildConfig
import es.openbank.remote.ApiKeyConfigContract
import es.openbank.remote.security.HashGenerator

class ApiKeyConfig(private val hashGenerator: HashGenerator): ApiKeyConfigContract {
    override fun getPublicKey(): String = BuildConfig.PUBLIC_KEY

    override fun getHash(timeStamp: String): String {
        return hashGenerator.generateHash(timeStamp + getPrivateKey() + getPublicKey())
    }

    private fun getPrivateKey() = BuildConfig.PRIVATE_KEY
}