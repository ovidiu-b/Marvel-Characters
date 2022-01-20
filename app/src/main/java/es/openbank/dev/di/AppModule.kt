package es.openbank.dev.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import es.openbank.config.session.AppSessionContract
import es.openbank.dev.App
import es.openbank.dev.apikey.ApiKeyConfig
import es.openbank.dev.session.AppSession
import es.openbank.remote.ApiKeyConfigContract
import es.openbank.remote.security.HashGenerator
import javax.inject.Singleton

const val APP_SHARED_PREFERENCES_NAME = "app_session"

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideApplication(app: App): Context = app

    @Provides
    @Singleton
    fun apyKeyConfig(hashGenerator: HashGenerator): ApiKeyConfigContract = ApiKeyConfig(hashGenerator)

    @Provides
    fun sharedPreferences(context: Context): SharedPreferences
        = context.getSharedPreferences(APP_SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun appSession(sharedPreferences: SharedPreferences): AppSessionContract = AppSession(sharedPreferences)
}