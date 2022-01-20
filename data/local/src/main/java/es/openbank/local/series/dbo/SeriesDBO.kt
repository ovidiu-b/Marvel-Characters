package es.openbank.local.series.dbo

import androidx.room.Embedded
import androidx.room.Entity
import es.openbank.local.common.dbo.ThumbnailDBO

@Entity(primaryKeys = ["seriesId"])
data class SeriesDBO(
    val seriesId: Int,
    val title: String,
    @Embedded
    val thumbnail: ThumbnailDBO
)