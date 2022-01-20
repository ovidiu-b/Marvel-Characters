package es.openbank.repository.characters

import es.openbank.config.session.AppSessionContract
import es.openbank.datasource.characters.CharactersLocalDataSource
import es.openbank.datasource.characters.CharactersRemoteDataSource
import es.openbank.model.characterGrid.CharacterBO
import es.openbank.model.comicGrid.ComicBO
import es.openbank.model.seriesGrid.SeriesBO
import es.openbank.repository.util.CacheableRemoteResponse
import es.openbank.repository.util.RepositoryResponse

interface CharactersRepository {

    suspend fun getCharacters(forceRequest: Boolean): RepositoryResponse<List<CharacterBO>>

    suspend fun getCharacter(id: Int): RepositoryResponse<CharacterBO?>

    suspend fun getComics(id: Int): RepositoryResponse<List<ComicBO>>

    suspend fun getSeries(id: Int): RepositoryResponse<List<SeriesBO>>

}

class CharactersRepositoryImpl(
    private val remote: CharactersRemoteDataSource,
    private val local: CharactersLocalDataSource,
    private val session: AppSessionContract
) : CharactersRepository {

    override suspend fun getCharacters(forceRequest: Boolean): RepositoryResponse<List<CharacterBO>> {
        return object: CacheableRemoteResponse<List<CharacterBO>>() {
            override suspend fun loadFromLocal(): List<CharacterBO> {
                return local.getCharacters().sortedBy { it.name }
            }

            override fun shouldRequestFromRemote(localResponse: List<CharacterBO>): Boolean {
                val cacheTimeExpired =
                    System.currentTimeMillis() - session.getLastTimeCharactersFetched() > session.getMaxCacheTime()
                return forceRequest || localResponse.isEmpty() || cacheTimeExpired
            }

            override suspend fun requestRemoteCall(): List<CharacterBO> {
                session.setLastTimeCharactersFetched(System.currentTimeMillis())
                return remote.getCharacters().sortedBy { it.name }
            }

            override suspend fun saveRemoteResponse(remoteResponse: List<CharacterBO>) {
                local.insertCharacter(remoteResponse)
            }
        }.execute()
    }

    override suspend fun getCharacter(id: Int): RepositoryResponse<CharacterBO?> {
        return object: CacheableRemoteResponse<CharacterBO?>() {
            override suspend fun loadFromLocal(): CharacterBO? {
                return local.getCharacter(id)
            }

            override fun shouldRequestFromRemote(localResponse: CharacterBO?): Boolean {
                return localResponse == null
            }

            override suspend fun requestRemoteCall(): CharacterBO? {
                return remote.getCharacter(id)
            }

            override suspend fun saveRemoteResponse(remoteResponse: CharacterBO?) {
                remoteResponse?.let { local.insertCharacter(listOf(it)) }
            }
        }.execute()
    }

    override suspend fun getComics(id: Int): RepositoryResponse<List<ComicBO>> {
        return object: CacheableRemoteResponse<List<ComicBO>>() {
            override suspend fun loadFromLocal(): List<ComicBO> {
                return local.getCharacterComics(id)
            }

            override fun shouldRequestFromRemote(localResponse: List<ComicBO>): Boolean {
                val cacheTimeExpired =
                    System.currentTimeMillis() - session.getLastTimeComicsFetched() > session.getMaxCacheTime()
                return localResponse.isEmpty() || cacheTimeExpired
            }

            override suspend fun requestRemoteCall(): List<ComicBO> {
                session.setLastTimeComicsFetched(System.currentTimeMillis())
                return remote.getComics(id)
            }

            override suspend fun saveRemoteResponse(remoteResponse: List<ComicBO>) {
                local.insertCharacterComics(id, remoteResponse)
            }

        }.execute()
    }

    override suspend fun getSeries(id: Int): RepositoryResponse<List<SeriesBO>> {
        return object: CacheableRemoteResponse<List<SeriesBO>>() {
            override suspend fun loadFromLocal(): List<SeriesBO> {
                return local.getCharacterSeries(id)
            }

            override fun shouldRequestFromRemote(localResponse: List<SeriesBO>): Boolean {
                val cacheTimeExpired =
                    System.currentTimeMillis() - session.getLastTimeSeriesFetched() > session.getMaxCacheTime()
                return localResponse.isEmpty() || cacheTimeExpired
            }

            override suspend fun requestRemoteCall(): List<SeriesBO> {
                session.setLastTimeSeriesFetched(System.currentTimeMillis())
                return remote.getSeries(id)
            }

            override suspend fun saveRemoteResponse(remoteResponse: List<SeriesBO>) {
                local.insertCharacterSeries(id, remoteResponse)
            }
        }.execute()
    }
}