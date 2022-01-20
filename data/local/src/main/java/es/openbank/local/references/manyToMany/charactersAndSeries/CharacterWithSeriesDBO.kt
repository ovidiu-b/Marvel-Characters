package es.openbank.local.references.manyToMany.charactersAndSeries

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import es.openbank.local.characters.dbo.CharacterDBO
import es.openbank.local.series.dbo.SeriesDBO

data class CharacterWithSeriesDBO(
    @Embedded val character: CharacterDBO,
    @Relation(
        parentColumn = "characterId",
        entityColumn = "seriesId",
        associateBy = Junction(CharacterSeriesJoinIds::class)
    )
    val series: List<SeriesDBO>
)
