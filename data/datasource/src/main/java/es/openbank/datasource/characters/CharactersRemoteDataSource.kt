package es.openbank.datasource.characters

import es.openbank.model.characterGrid.CharacterBO
import es.openbank.model.comicGrid.ComicBO
import es.openbank.model.seriesGrid.SeriesBO

interface CharactersRemoteDataSource {

    suspend fun getCharacters(): List<CharacterBO>

    suspend fun getCharacter(id: Int): CharacterBO?

    suspend fun getComics(id: Int): List<ComicBO>

    suspend fun getSeries(id: Int): List<SeriesBO>

}