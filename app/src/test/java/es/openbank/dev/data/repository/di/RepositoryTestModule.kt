package es.openbank.dev.data.repository.di

import dagger.Module
import dagger.Provides
import es.openbank.config.session.AppSessionContract
import es.openbank.datasource.characters.CharactersLocalDataSource
import es.openbank.datasource.characters.CharactersRemoteDataSource
import es.openbank.dev.testDoubles.fakes.datasource.characters.CharactersLocalDataSourceFake
import es.openbank.dev.testDoubles.fakes.datasource.characters.CharactersRemoteDataSourceFake
import es.openbank.dev.testDoubles.fakes.repository.characters.CharactersRepositoryFake
import es.openbank.model.characterGrid.CharacterBO
import es.openbank.model.comicGrid.ComicBO
import es.openbank.model.common.ThumbnailBO
import es.openbank.model.seriesGrid.SeriesBO
import es.openbank.repository.characters.CharactersRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher

@Module
class RepositoryTestModule {

    @ExperimentalCoroutinesApi
    @Provides
    fun appDispatchersProvider(): CoroutineDispatcher = TestCoroutineDispatcher()

    @Provides
    fun charactersRepositoryProvider(): CharactersRepository = CharactersRepositoryFake()

    @Provides
    fun provideFakeCharactersRemoteDataSource(): CharactersRemoteDataSource = CharactersRemoteDataSourceFake()

    @Provides
    fun provideFakeCharactersLocalDataSource(): CharactersLocalDataSource = CharactersLocalDataSourceFake()

}