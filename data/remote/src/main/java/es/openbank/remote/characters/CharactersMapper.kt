package es.openbank.remote.characters

import es.openbank.model.characterGrid.CharacterBO
import es.openbank.remote.characters.dto.CharacterDTO
import es.openbank.remote.characters.dto.CharactersResponseDTO
import es.openbank.remote.common.toBO

fun CharactersResponseDTO.toBO(): List<CharacterBO> {
    return data.results.filterNot {
        it.thumbnail.path.contains("image_not_available")
    }.map {
        it.toBO()
    }
}

fun CharacterDTO.toBO() = CharacterBO(
    id = id,
    name = name,
    description = description,
    thumbnail = thumbnail.toBO()
)
