package es.openbank.dev.di

import android.content.Context
import dagger.Module
import dagger.Provides
import es.openbank.config.session.AppSessionContract
import es.openbank.dev.TestApp
import es.openbank.dev.apikey.ApiKeyConfig
import es.openbank.remote.ApiKeyConfigContract
import es.openbank.remote.security.HashGenerator
import javax.inject.Singleton

@Module
class TestAppModule {

    @Provides
    @Singleton
    fun provideApplication(app: TestApp): Context = app

    @Provides
    @Singleton
    fun apyKeyConfig(hashGenerator: HashGenerator): ApiKeyConfigContract = ApiKeyConfig(hashGenerator)

    @Provides
    @Singleton
    fun appSession(): AppSessionContract = object: AppSessionContract {
        override fun setLastTimeCharactersFetched(timeStamp: Long) { }
        override fun getLastTimeCharactersFetched(): Long = -1
        override fun setLastTimeComicsFetched(timeStamp: Long) { }
        override fun getLastTimeComicsFetched(): Long = -1
        override fun setLastTimeSeriesFetched(timeStamp: Long) { }
        override fun getLastTimeSeriesFetched(): Long = -1
        override fun getMaxCacheTime(): Long = Long.MAX_VALUE
    }

}