package es.openbank.domain.character

import es.openbank.model.characterGrid.CharacterBO
import es.openbank.repository.characters.CharactersRepository
import es.openbank.common.wrappers.AsyncResult
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val repository: CharactersRepository) {

    suspend operator fun invoke(forceRequest: Boolean = false): AsyncResult<List<CharacterBO>> {
        return repository.getCharacters(forceRequest).getResult()
    }

}