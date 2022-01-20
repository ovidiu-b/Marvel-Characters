package es.openbank.local.comics

import androidx.room.*
import es.openbank.local.comics.dbo.ComicDBO
import es.openbank.local.references.manyToMany.charactersAndComics.CharacterComicJoinIds

@Dao
abstract class ComicsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    protected abstract suspend fun insertComics(comics: List<ComicDBO>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    protected abstract suspend fun insertComicsWithCharacterId(comicsWithCharacterId: List<CharacterComicJoinIds>)

    @Transaction
    open suspend fun insertComics(comics: List<ComicDBO>, characterId: Int) {
        insertComics(comics)
        insertComicsWithCharacterId(comics.map { CharacterComicJoinIds(characterId, it.comicId) })
    }

}