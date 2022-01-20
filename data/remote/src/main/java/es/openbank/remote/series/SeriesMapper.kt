package es.openbank.remote.series

import es.openbank.model.seriesGrid.SeriesBO
import es.openbank.remote.common.toBO
import es.openbank.remote.series.dto.SeriesDTO
import es.openbank.remote.series.dto.SeriesResponseDTO

fun SeriesResponseDTO.toBO(): List<SeriesBO> {
    return data.results.map {
        it.toBO()
    }
}

fun SeriesDTO.toBO() = SeriesBO(id, title, thumbnail.toBO())