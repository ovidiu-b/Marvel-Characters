package es.openbank.domain.character

import es.openbank.model.comicGrid.ComicBO
import es.openbank.repository.characters.CharactersRepository
import es.openbank.common.wrappers.AsyncResult
import javax.inject.Inject

class GetCharacterComicsUseCase @Inject constructor(private val repository: CharactersRepository) {

    suspend operator fun invoke(id: Int): AsyncResult<List<ComicBO>> {
        return repository.getComics(id).getResult()
    }

}