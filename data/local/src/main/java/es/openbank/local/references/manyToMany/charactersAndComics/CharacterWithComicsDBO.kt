package es.openbank.local.references.manyToMany.charactersAndComics

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import es.openbank.local.characters.dbo.CharacterDBO
import es.openbank.local.comics.dbo.ComicDBO

data class CharacterWithComicsDBO (
    @Embedded val character: CharacterDBO,
    @Relation(
        parentColumn = "characterId",
        entityColumn = "comicId",
        associateBy = Junction(CharacterComicJoinIds::class)
    )
    val comics: List<ComicDBO>
)