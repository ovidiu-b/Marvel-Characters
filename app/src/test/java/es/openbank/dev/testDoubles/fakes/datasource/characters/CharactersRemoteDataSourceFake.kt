package es.openbank.dev.testDoubles.fakes.datasource.characters

import es.openbank.datasource.characters.CharactersRemoteDataSource
import es.openbank.model.characterGrid.CharacterBO
import es.openbank.model.comicGrid.ComicBO
import es.openbank.model.common.ThumbnailBO
import es.openbank.model.seriesGrid.SeriesBO

class CharactersRemoteDataSourceFake: CharactersRemoteDataSource {
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