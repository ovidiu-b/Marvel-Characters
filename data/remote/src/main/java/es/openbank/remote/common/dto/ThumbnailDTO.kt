package es.openbank.remote.common.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ThumbnailDTO (
    val extension: String,
    val path: String
)