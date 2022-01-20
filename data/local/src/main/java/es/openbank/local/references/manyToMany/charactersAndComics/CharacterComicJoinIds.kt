package es.openbank.local.references.manyToMany.charactersAndComics

import androidx.room.Entity

@Entity(primaryKeys = ["characterId", "comicId"])
data class CharacterComicJoinIds (
    val characterId: Int,
    val comicId: Int
)