package es.openbank.remote.characters.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharactersResponseDTO(
    val data: CharactersDataDTO
)
