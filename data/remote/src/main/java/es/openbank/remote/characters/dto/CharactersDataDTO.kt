package es.openbank.remote.characters.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharactersDataDTO (
    val results: List<CharacterDTO>
)