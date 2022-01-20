package es.openbank.repository.di

import dagger.Module
import dagger.Provides
import es.openbank.config.session.AppSessionContract
import es.openbank.datasource.characters.CharactersLocalDataSource
import es.openbank.datasource.characters.CharactersRemoteDataSource
import es.openbank.repository.characters.CharactersRepository
import es.openbank.repository.characters.CharactersRepositoryImpl
import es.openbank.repository.util.AppDispatchers
import kotlinx.coroutines.Dispatchers

@Module
class RepositoryModule {

    @Provides
    fun appDispatchersProvider() = AppDispatchers(Dispatchers.Main, Dispatchers.IO)

    @Provides
    fun charactersRepositoryProvider(
        remote: CharactersRemoteDataSource,
        local: CharactersLocalDataSource,
        session: AppSessionContract
    ): CharactersRepository = CharactersRepositoryImpl(remote, local, session)

}