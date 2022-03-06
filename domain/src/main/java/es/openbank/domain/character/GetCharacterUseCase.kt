package es.openbank.domain.character

import es.openbank.model.characterGrid.CharacterBO
import es.openbank.repository.characters.CharactersRepository
import es.openbank.common.wrappers.AsyncResult
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(private val repository: CharactersRepository) {

    suspend operator fun invoke(id: Int): AsyncResult<CharacterBO?> {
        return repository.getCharacter(id).getResult()
    }

}