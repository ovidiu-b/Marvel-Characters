package es.openbank.dev.features.character

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import es.openbank.character.ui.viewModel.CharacterGridViewModel
import es.openbank.common.wrappers.AsyncResult
import es.openbank.dev.TestApp
import es.openbank.dev.di.DaggerTestAppComponent
import es.openbank.dev.util.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@ExperimentalCoroutinesApi
class CharacterGridViewModelTest {

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    @Inject
    lateinit var sut: CharacterGridViewModel

    @Before
    fun setUp() {
        DaggerTestAppComponent.builder()
            .application(TestApp())
            .build()
            .inject(this)
    }

    @Test
    fun `check if characters are retrieved correctly with loading and without any errors`() = runBlockingTest {
        assertThat(sut.charactersLiveData.getOrAwaitValue()).isInstanceOf(AsyncResult.LOADING::class.java)

        sut.requestCharacters()

        val successOrErrorValue = sut.charactersLiveData.getOrAwaitValue()

        assertThat(successOrErrorValue).isInstanceOf(AsyncResult.SUCCESS::class.java)
        assertThat(successOrErrorValue.data).isNotNull()
        assertThat(successOrErrorValue.data).isNotEmpty()
    }

}