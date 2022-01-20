package es.openbank.character.domain

import es.openbank.model.comicGrid.ComicBO
import es.openbank.repository.characters.CharactersRepository
import es.openbank.repository.util.AsyncResult
import javax.inject.Inject

class GetCharacterComicsUseCase @Inject constructor(private val repository: CharactersRepository) {

    suspend operator fun invoke(id: Int): AsyncResult<List<ComicBO>> {
        return repository.getComics(id).getResult()
    }

}