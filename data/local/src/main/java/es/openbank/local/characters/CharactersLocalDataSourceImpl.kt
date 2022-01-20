package es.openbank.local.characters

import es.openbank.datasource.characters.CharactersLocalDataSource
import es.openbank.local.comics.ComicsDAO
import es.openbank.local.comics.toBO
import es.openbank.local.comics.toDBO
import es.openbank.local.series.SeriesDAO
import es.openbank.local.series.toBO
import es.openbank.local.series.toDBO
import es.openbank.model.characterGrid.CharacterBO
import es.openbank.model.comicGrid.ComicBO
import es.openbank.model.seriesGrid.SeriesBO

class CharactersLocalDataSourceImpl(
    private val charactersDao: CharactersDAO,
    private val comicsDao: ComicsDAO,
    private val seriesDao: SeriesDAO
): CharactersLocalDataSource {

    override suspend fun insertCharacter(characters: List<CharacterBO>) {
        charactersDao.insertCharacter(characters.toDBO())
    }

    override suspend fun insertCharacterComics(characterId: Int, comics: List<ComicBO>) {
        comicsDao.insertComics(comics.toDBO(), characterId)
    }

    override suspend fun insertCharacterSeries(characterId: Int, series: List<SeriesBO>) {
        seriesDao.insertSeries(series.toDBO(), characterId)
    }

    override suspend fun getCharacters(): List<CharacterBO> {
        return charactersDao.getCharacters().toBO()
    }

    override suspend fun getCharacter(id: Int): CharacterBO? {
        return charactersDao.getCharacter(id)?.toBO()
    }

    override suspend fun getCharacterComics(id: Int): List<ComicBO> {
        return charactersDao.getCharacterWithComics(id).comics.toBO()
    }

    override suspend fun getCharacterSeries(id: Int): List<SeriesBO> {
        return charactersDao.getCharacterWithSeries(id).series.toBO()
    }

}