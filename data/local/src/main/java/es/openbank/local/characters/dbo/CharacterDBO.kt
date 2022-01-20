package es.openbank.local.characters.dbo

import androidx.room.Embedded
import androidx.room.Entity
import es.openbank.local.common.dbo.ThumbnailDBO

@Entity(primaryKeys = ["characterId"])
data class CharacterDBO(
    val characterId: Int,
    val name: String,
    val description: String,
    @Embedded
    val thumbnail: ThumbnailDBO
)
