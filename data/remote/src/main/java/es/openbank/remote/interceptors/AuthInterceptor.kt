package es.openbank.remote.interceptors

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor(
    private val publicKey: String,
    private val timeStamp: String,
    private val hash: String
): Interceptor {

    companion object {
        private const val TS_PARAM = "ts"
        private const val API_KEY_PARAM = "apikey"
        private const val HASH_PARAM = "hash"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val originalHttpUrl: HttpUrl = original.url

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(TS_PARAM, timeStamp)
            .addQueryParameter(API_KEY_PARAM, publicKey)
            .addQueryParameter(HASH_PARAM, hash)
            .build()

        val requestBuilder: Request.Builder = original.newBuilder().url(url)

        val request: Request = requestBuilder.build()

        return chain.proceed(request)
    }
}