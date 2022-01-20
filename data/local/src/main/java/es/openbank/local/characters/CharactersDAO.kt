package es.openbank.local.characters

import androidx.room.*
import es.openbank.local.characters.dbo.CharacterDBO
import es.openbank.local.references.manyToMany.charactersAndComics.CharacterWithComicsDBO
import es.openbank.local.references.manyToMany.charactersAndSeries.CharacterWithSeriesDBO

@Dao
abstract class CharactersDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertCharacter(characters: List<CharacterDBO>)

    @Query("SELECT * FROM CharacterDBO")
    abstract suspend fun getCharacters(): List<CharacterDBO>

    @Query("SELECT * FROM CharacterDBO WHERE characterId=:id")
    abstract suspend fun getCharacter(id: Int): CharacterDBO?

    @Transaction
    @Query("SELECT * FROM CharacterDBO WHERE characterId=:id")
    abstract suspend fun getCharacterWithComics(id: Int): CharacterWithComicsDBO

    @Transaction
    @Query("SELECT * FROM CharacterDBO WHERE characterId=:id")
    abstract suspend fun getCharacterWithSeries(id: Int): CharacterWithSeriesDBO

}