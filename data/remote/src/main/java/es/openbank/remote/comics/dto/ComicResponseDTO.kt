package es.openbank.remote.comics.dto

import com.squareup.moshi.JsonClass
import es.openbank.remote.common.dto.ThumbnailDTO

@JsonClass(generateAdapter = true)
data class ComicResponseDTO(
    val data: ComicDataDTO
)

@JsonClass(generateAdapter = true)
data class ComicDataDTO(
    val results: List<ComicDTO>
)

@JsonClass(generateAdapter = true)
data class ComicDTO(
    val id: Int,
    val thumbnail: ThumbnailDTO,
    val title: String
)
