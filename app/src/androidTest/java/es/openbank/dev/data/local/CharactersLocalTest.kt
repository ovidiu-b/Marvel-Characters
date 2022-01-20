package es.openbank.dev.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.google.common.truth.Truth.assertThat
import es.openbank.local.AppRoomDatabase
import es.openbank.local.characters.CharactersDAO
import es.openbank.local.characters.toBO
import es.openbank.local.characters.toDBO
import es.openbank.local.comics.ComicsDAO
import es.openbank.local.comics.toBO
import es.openbank.local.comics.toDBO
import es.openbank.local.series.SeriesDAO
import es.openbank.local.series.toBO
import es.openbank.local.series.toDBO
import es.openbank.model.characterGrid.CharacterBO
import es.openbank.model.comicGrid.ComicBO
import es.openbank.model.common.ThumbnailBO
import es.openbank.model.seriesGrid.SeriesBO
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4ClassRunner::class)
class CharactersLocalTest {

    private lateinit var db: AppRoomDatabase
    private lateinit var charactersDao: CharactersDAO
    private lateinit var comicsDao: ComicsDAO
    private lateinit var seriesDao: SeriesDAO

    private val characterId = 1
    private val character = CharacterBO(
        characterId, "Character $characterId", "", ThumbnailBO("path $characterId", "jpg")
    )
    private val comics = listOf(
        ComicBO(1, "Comic 1", ThumbnailBO("path 1", "jpg")),
        ComicBO(2, "Comic 2", ThumbnailBO("path 2", "jpg")),
        ComicBO(3, "Comic 3", ThumbnailBO("path 3", "jpg"))
    )
    private val series = listOf(
        SeriesBO(1, "Series 1", ThumbnailBO("path1", "jpg")),
        SeriesBO(2, "Series 2", ThumbnailBO("path2", "jpg"))
    )

    @Before
    fun openDB() {
        db = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), AppRoomDatabase::class.java).build()
        charactersDao = db.charactersDao()
        comicsDao = db.comicsDao()
        seriesDao = db.seriesDao()
    }

    @After
    fun closeDB() {
        db.close()
    }

    @Test
    fun insertAndReadCharacter() = runBlocking {
        charactersDao.insertCharacter(listOf(character.toDBO()))

        assertThat(character).isEqualTo(charactersDao.getCharacter(characterId)?.toBO())
    }

    @Test
    fun insertAndReadCharacterComics(): Unit = runBlocking {
        charactersDao.insertCharacter(listOf(character.toDBO()))
        comicsDao.insertComics(comics.toDBO(), characterId)

        val characterWithComics = charactersDao.getCharacterWithComics(characterId)

        assertThat(characterWithComics).isNotNull()
        assertThat(characterWithComics.character.toBO()).isEqualTo(character)
        assertThat(characterWithComics.comics.toBO()).containsExactlyElementsIn(comics)
    }

    @Test
    fun insertAndReadCharacterSeries(): Unit = runBlocking {
        charactersDao.insertCharacter(listOf(character.toDBO()))
        seriesDao.insertSeries(series.toDBO(), characterId)

        val characterWithSeries = charactersDao.getCharacterWithSeries(characterId)

        assertThat(characterWithSeries).isNotNull()
        assertThat(characterWithSeries.character.toBO()).isEqualTo(character)
        assertThat(characterWithSeries.series.toBO()).containsExactlyElementsIn(series)
    }
}