package es.openbank.local.series

import es.openbank.local.common.toBO
import es.openbank.local.common.toDBO
import es.openbank.local.series.dbo.SeriesDBO
import es.openbank.model.seriesGrid.SeriesBO

fun List<SeriesBO>.toDBO(): List<SeriesDBO> {
    return map { it.toDBO() }
}

fun List<SeriesDBO>.toBO(): List<SeriesBO> {
    return map { it.toBO() }
}

fun SeriesBO.toDBO() = SeriesDBO(
    id,
    title,
    thumbnail.toDBO()
)

fun SeriesDBO.toBO() = SeriesBO(
    seriesId,
    title,
    thumbnail.toBO()
)