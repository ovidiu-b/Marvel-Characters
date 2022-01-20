package es.openbank.character.domain

import es.openbank.model.seriesGrid.SeriesBO
import es.openbank.repository.characters.CharactersRepository
import es.openbank.repository.util.AsyncResult
import javax.inject.Inject

class GetCharacterSeriesUseCase @Inject constructor(private val repository: CharactersRepository) {

    suspend operator fun invoke(id: Int): AsyncResult<List<SeriesBO>> {
        return repository.getSeries(id).getResult()
    }

}