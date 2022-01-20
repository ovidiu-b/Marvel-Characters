package es.openbank.remote.series.dto

import com.squareup.moshi.JsonClass
import es.openbank.remote.common.dto.ThumbnailDTO

@JsonClass(generateAdapter = true)
data class SeriesResponseDTO(
    val data: SeriesDataDTO
)

@JsonClass(generateAdapter = true)
data class SeriesDataDTO(
    val results: List<SeriesDTO>
)

@JsonClass(generateAdapter = true)
data class SeriesDTO(
    val id: Int,
    val thumbnail: ThumbnailDTO,
    val title: String
)
