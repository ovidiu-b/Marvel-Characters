package es.openbank.local.references.manyToMany.charactersAndSeries

import androidx.room.Entity

@Entity(primaryKeys = ["characterId", "seriesId"])
data class CharacterSeriesJoinIds (
    val characterId: Int,
    val seriesId: Int
)