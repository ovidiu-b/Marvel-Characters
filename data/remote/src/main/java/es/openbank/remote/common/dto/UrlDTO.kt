package es.openbank.remote.common.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UrlDTO(
    val type: String,
    val url: String
)