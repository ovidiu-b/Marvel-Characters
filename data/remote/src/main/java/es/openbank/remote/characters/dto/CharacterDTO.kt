package es.openbank.remote.characters.dto

import com.squareup.moshi.JsonClass
import es.openbank.remote.common.dto.CollectionRelatedDTO
import es.openbank.remote.common.dto.ThumbnailDTO
import es.openbank.remote.common.dto.UrlDTO

@JsonClass(generateAdapter = true)
data class CharacterDTO(
    val id: Int,
    val description: String,
    val name: String,
    val thumbnail: ThumbnailDTO,
    val modified: String,
    val resourceURI: String,
    val series: CollectionRelatedDTO,
    val stories: CollectionRelatedDTO,
    val comics: CollectionRelatedDTO,
    val events: CollectionRelatedDTO,
    val urls: List<UrlDTO>
)
