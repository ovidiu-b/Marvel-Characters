package es.openbank.dev.data.repository.di

import dagger.Module
import dagger.Provides
import es.openbank.config.session.AppSessionContract
import es.openbank.datasource.characters.CharactersLocalDataSource
import es.openbank.datasource.characters.CharactersRemoteDataSource
import es.openbank.model.characterGrid.CharacterBO
import es.openbank.model.comicGrid.ComicBO
import es.openbank.model.common.ThumbnailBO
import es.openbank.model.seriesGrid.SeriesBO
import es.openbank.repository.characters.CharactersRepository
import es.openbank.repository.characters.CharactersRepositoryImpl
import es.openbank.repository.util.AppDispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher

@Module
class RepositoryTestModule {

    @ExperimentalCoroutinesApi
    @Provides
    fun appDispatchersProvider() = AppDispatchers(TestCoroutineDispatcher(), TestCoroutineDispatcher())

    @Provides
    fun charactersRepositoryProvider(
        remote: CharactersRemoteDataSource,
        local: CharactersLocalDataSource,
        session: AppSessionContract
    ): CharactersRepository = CharactersRepositoryImpl(remote, local, session)

    @Provides
    fun provideFakeCharactersRemoteDataSource(): CharactersRemoteDataSource {
        return object: CharactersRemoteDataSource {
            override suspend fun getCharacters(): List<CharacterBO> {
                return listOf(
                    CharacterBO(1, "Character 1", "", ThumbnailBO("path1", "jpg")),
                    CharacterBO(2, "Character 2", "", ThumbnailBO("path2", "jpg"))
                )
            }

            override suspend fun getCharacter(id: Int): CharacterBO {
                return CharacterBO(id, "Character $id", "", ThumbnailBO("path $id", "jpg"))
            }

            override suspend fun getComics(id: Int): List<ComicBO> {
                return listOf(
                    ComicBO(1, "Comic 1", ThumbnailBO("path1", "jpg")),
                    ComicBO(2, "Comic 2", ThumbnailBO("path2", "jpg")),
                    ComicBO(3, "Comic 3", ThumbnailBO("path3", "jpg"))
                )
            }

            override suspend fun getSeries(id: Int): List<SeriesBO> {
                return listOf(
                    SeriesBO(1, "Series 1", ThumbnailBO("path1", "jpg")),
                    SeriesBO(2, "Series 2", ThumbnailBO("path2", "jpg"))
                )
            }
        }
    }

    @Provides
    fun provideFakeCharactersLocalDataSource(): CharactersLocalDataSource {
        return object: CharactersLocalDataSource {
            override suspend fun insertCharacter(characters: List<CharacterBO>) { }

            override suspend fun insertCharacterComics(characterId: Int, comics: List<ComicBO>) { }

            override suspend fun insertCharacterSeries(characterId: Int, series: List<SeriesBO>) { }

            override suspend fun getCharacters(): List<CharacterBO> {
                return listOf(
                    CharacterBO(1, "Character 1 - From Local", "", ThumbnailBO("path1 - From Local", "jpg")),
                    CharacterBO(2, "Character 2 - From Local", "", ThumbnailBO("path2 - From Local", "jpg"))
                )
            }

            override suspend fun getCharacter(id: Int): CharacterBO {
                return CharacterBO(id, "Character $id - From Local", "", ThumbnailBO("path $id", "jpg"))
            }

            override suspend fun getCharacterComics(id: Int): List<ComicBO> {
                return listOf(
                    ComicBO(1, "Comic 1 - From Local", ThumbnailBO("path1 - From Local", "jpg")),
                    ComicBO(2, "Comic 2 - From Local", ThumbnailBO("path2 - From Local", "jpg")),
                    ComicBO(3, "Comic 3 - From Local", ThumbnailBO("path3 - From Local", "jpg"))
                )
            }

            override suspend fun getCharacterSeries(id: Int): List<SeriesBO> {
                return listOf(
                    SeriesBO(1, "Series 1 - From Local", ThumbnailBO("path1 - From Local", "jpg")),
                    SeriesBO(2, "Series 2 - From Local", ThumbnailBO("path2 - From Local", "jpg"))
                )
            }
        }
    }
}