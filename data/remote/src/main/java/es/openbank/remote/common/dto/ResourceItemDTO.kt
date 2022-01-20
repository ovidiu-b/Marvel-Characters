package es.openbank.remote.common.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResourceItemDTO (
    val name: String,
    val resourceURI: String,
    val type: String?
)