package es.openbank.local.characters

import es.openbank.local.characters.dbo.CharacterDBO
import es.openbank.local.common.toBO
import es.openbank.local.common.toDBO
import es.openbank.model.characterGrid.CharacterBO

fun List<CharacterDBO>.toBO(): List<CharacterBO> {
    return map { it.toBO() }
}

fun List<CharacterBO>.toDBO() : List<CharacterDBO> {
    return map { it.toDBO() }
}

fun CharacterBO.toDBO() = CharacterDBO(
    id,
    name,
    description,
    thumbnail.toDBO()
)

fun CharacterDBO.toBO() = CharacterBO(
    characterId,
    name,
    description,
    thumbnail.toBO()
)