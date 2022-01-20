package es.openbank.character.domain

import es.openbank.model.characterGrid.CharacterBO
import es.openbank.repository.characters.CharactersRepository
import es.openbank.repository.util.AsyncResult
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val repository: CharactersRepository) {

    suspend operator fun invoke(forceRequest: Boolean = false): AsyncResult<List<CharacterBO>> {
        return repository.getCharacters(forceRequest).getResult()
    }

}