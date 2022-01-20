package es.openbank.remote.security

import java.math.BigInteger
import java.security.MessageDigest

class Md5Generator: HashGenerator {

    companion object {
        private const val MD5 = "MD5"
    }

    override fun generateHash(password: String): String {
        val md = MessageDigest.getInstance(MD5)
        return BigInteger(1, md.digest(password.toByteArray())).toString(16).padStart(32, '0')
    }

}