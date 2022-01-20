package es.openbank.local.comics.dbo

import androidx.room.Embedded
import androidx.room.Entity
import es.openbank.local.common.dbo.ThumbnailDBO

@Entity(primaryKeys = ["comicId"])
data class ComicDBO(
    val comicId: Int,
    val title: String,
    @Embedded
    val thumbnail: ThumbnailDBO
)