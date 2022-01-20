package es.openbank.remote.di

import dagger.Module
import dagger.Provides
import es.openbank.datasource.characters.CharactersRemoteDataSource
import es.openbank.remote.ApiKeyConfigContract
import es.openbank.remote.characters.CharactersRemoteDataSourceImpl
import es.openbank.remote.characters.CharactersService
import es.openbank.remote.interceptors.AuthInterceptor
import es.openbank.remote.security.HashGenerator
import es.openbank.remote.security.Md5Generator
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class RemoteModule {
    companion object {
        private const val BASE_URL = "https://gateway.marvel.com/"
    }

    @Provides
    fun loggingInterceptor() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.HEADERS
        }

    @Provides
    fun authInterceptor(apiKeyConfig: ApiKeyConfigContract): AuthInterceptor {
        val timeStamp = System.currentTimeMillis().toString()

        return AuthInterceptor(
            publicKey = apiKeyConfig.getPublicKey(),
            hash = apiKeyConfig.getHash(timeStamp),
            timeStamp = timeStamp
        )
    }

    @Provides
    fun md5HashGenerator(): HashGenerator = Md5Generator()

    @Provides
    fun okHttpClientProvider(loggingInterceptor: HttpLoggingInterceptor, authInterceptor: AuthInterceptor) =
        OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(authInterceptor)
            .build()

    @Provides
    @Singleton
    fun retrofitProvider(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Provides
    fun charactersServiceProvider(retrofit: Retrofit): CharactersService = retrofit.create(CharactersService::class.java)

    @Provides
    fun charactersRemoteDataSourceProvider(charactersService: CharactersService): CharactersRemoteDataSource
        = CharactersRemoteDataSourceImpl(charactersService)

}