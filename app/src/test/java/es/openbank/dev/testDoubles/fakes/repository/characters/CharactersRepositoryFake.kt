package es.openbank.dev.testDoubles.fakes.repository.characters

import es.openbank.model.characterGrid.CharacterBO
import es.openbank.model.comicGrid.ComicBO
import es.openbank.common.wrappers.ErrorResult
import es.openbank.model.common.ThumbnailBO
import es.openbank.model.seriesGrid.SeriesBO
import es.openbank.repository.characters.CharactersRepository
import es.openbank.repository.util.RepositoryResponse

class CharactersRepositoryFake: CharactersRepository {
    private val characters = mutableListOf(
        CharacterBO(1, "Character 1", "", ThumbnailBO("path1", "jpg")),
        CharacterBO(2, "Character 2", "", ThumbnailBO("path2", "jpg")),
        CharacterBO(3, "Character 3", "", ThumbnailBO("path3", "jpg"))
    )
    private val comics = mutableListOf<ComicBO>()
    private val series = mutableListOf<SeriesBO>()

    override suspend fun insertCharacter(characterBO: CharacterBO): RepositoryResponse<Unit> {
        return try {
            characters.add(characterBO)
            RepositoryResponse.onSuccess { }
        } catch (e: Throwable) {
            RepositoryResponse.onError { ErrorResult.InsertError }
        }
    }

    override suspend fun getCharacters(forceRequest: Boolean): RepositoryResponse<List<CharacterBO>> {
        return RepositoryResponse.onSuccess { characters }
    }

    override suspend fun getCharacter(id: Int): RepositoryResponse<CharacterBO?> {
        return characters
            .find { it.id == id }
            ?.run { RepositoryResponse.onSuccess { this } }
            ?: RepositoryResponse.onError { ErrorResult.NotFoundError }
    }

    override suspend fun getComics(id: Int): RepositoryResponse<List<ComicBO>> {
        return RepositoryResponse.onSuccess { comics }
    }

    override suspend fun getSeries(id: Int): RepositoryResponse<List<SeriesBO>> {
        return RepositoryResponse.onSuccess { series }
    }
}