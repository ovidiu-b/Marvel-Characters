package es.openbank.dev.data.remote.di

import dagger.Module
import dagger.Provides
import es.openbank.remote.security.HashGenerator
import es.openbank.remote.security.Md5Generator

@Module
class RemoteTestModule {

    @Provides
    fun md5HashGenerator(): HashGenerator = Md5Generator()

}