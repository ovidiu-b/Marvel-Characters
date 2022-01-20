package es.openbank.remote.common.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CollectionRelatedDTO (
    val available: Int,
    val collectionURI: String,
    val items: List<ResourceItemDTO>,
    val returned: Int
)