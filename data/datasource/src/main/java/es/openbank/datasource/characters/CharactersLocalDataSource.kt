package es.openbank.datasource.characters

import es.openbank.model.characterGrid.CharacterBO
import es.openbank.model.comicGrid.ComicBO
import es.openbank.model.seriesGrid.SeriesBO

interface CharactersLocalDataSource {

    suspend fun insertCharacter(characters: List<CharacterBO>)

    suspend fun insertCharacterComics(characterId: Int, comics: List<ComicBO>)

    suspend fun insertCharacterSeries(characterId: Int, series: List<SeriesBO>)

    suspend fun getCharacters(): List<CharacterBO>

    suspend fun getCharacter(id: Int): CharacterBO?

    suspend fun getCharacterComics(id: Int): List<ComicBO>

    suspend fun getCharacterSeries(id: Int): List<SeriesBO>

}