package es.openbank.local.series

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import es.openbank.local.references.manyToMany.charactersAndSeries.CharacterSeriesJoinIds
import es.openbank.local.series.dbo.SeriesDBO

@Dao
abstract class SeriesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    protected abstract suspend fun insertSeries(series: List<SeriesDBO>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    protected abstract suspend fun insertSeriesWithCharacterId(comicsWithCharacterId: List<CharacterSeriesJoinIds>)

    @Transaction
    open suspend fun insertSeries(series: List<SeriesDBO>, characterId: Int) {
        insertSeries(series)
        insertSeriesWithCharacterId(series.map { CharacterSeriesJoinIds(characterId, it.seriesId) })
    }

}