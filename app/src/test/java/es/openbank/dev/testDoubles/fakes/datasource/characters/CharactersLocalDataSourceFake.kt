package es.openbank.dev.testDoubles.fakes.datasource.characters

import es.openbank.datasource.characters.CharactersLocalDataSource
import es.openbank.model.characterGrid.CharacterBO
import es.openbank.model.comicGrid.ComicBO
import es.openbank.model.common.ThumbnailBO
import es.openbank.model.seriesGrid.SeriesBO

class CharactersLocalDataSourceFake: CharactersLocalDataSource {
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