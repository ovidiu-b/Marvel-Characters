package es.openbank.dev.data.repository

import com.google.common.truth.Truth.assertThat
import es.openbank.config.session.AppSessionContract
import es.openbank.datasource.characters.CharactersLocalDataSource
import es.openbank.datasource.characters.CharactersRemoteDataSource
import es.openbank.dev.TestApp
import es.openbank.dev.di.DaggerTestAppComponent
import es.openbank.repository.characters.CharactersRepositoryImpl
import es.openbank.repository.util.AsyncResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import javax.inject.Inject

@ExperimentalCoroutinesApi
class CharactersRepositoryTest {

    @Inject
    lateinit var remote: CharactersRemoteDataSource

    @Inject
    lateinit var local: CharactersLocalDataSource

    @Inject
    lateinit var session: AppSessionContract

    @Before
    fun setup() {
        DaggerTestAppComponent.builder()
            .application(TestApp())
            .build()
            .inject(this)
    }

    @Test
    fun `get characters from remote`(): Unit = runBlocking {
        val repository = CharactersRepositoryImpl(remote, local, session)

        val result = repository.getCharacters(true).getResult()

        assertThat(result.status).isEqualTo(AsyncResult.Status.SUCCESS)
        assertThat(result.data).isNotNull()
        assertThat(result.data).containsExactlyElementsIn(remote.getCharacters())
    }

    @Test
    fun `get characters from local`(): Unit = runBlocking {
        val repository = CharactersRepositoryImpl(remote, local, session)

        val result = repository.getCharacters(false).getResult()

        assertThat(result.status).isEqualTo(AsyncResult.Status.SUCCESS)
        assertThat(result.data).isNotNull()
        assertThat(result.data).containsExactlyElementsIn(local.getCharacters())
    }
}
