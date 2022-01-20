package es.openbank.remote.characters

import es.openbank.datasource.characters.CharactersRemoteDataSource
import es.openbank.model.characterGrid.CharacterBO
import es.openbank.model.comicGrid.ComicBO
import es.openbank.model.seriesGrid.SeriesBO
import es.openbank.remote.comics.toBO
import es.openbank.remote.error.RemoteErrorRequestExecutor
import es.openbank.remote.series.toBO

class CharactersRemoteDataSourceImpl(
    private val charactersService: CharactersService
): CharactersRemoteDataSource {

    override suspend fun getCharacters(): List<CharacterBO> {
        return RemoteErrorRequestExecutor.execute {
            charactersService.getCharacters().toBO()
        }
    }

    override suspend fun getCharacter(id: Int): CharacterBO? {
        return RemoteErrorRequestExecutor.execute {
            val response = charactersService.getCharacter(id)

            if (response.data.results.isEmpty()) {
                null
            } else {
                response.data.results.first().toBO()
            }

        }
    }

    override suspend fun getComics(id: Int): List<ComicBO> {
        return RemoteErrorRequestExecutor.execute {
            charactersService.getComics(id).toBO()
        }
    }

    override suspend fun getSeries(id: Int): List<SeriesBO> {
        return RemoteErrorRequestExecutor.execute {
            charactersService.getSeries(id).toBO()
        }
    }

}