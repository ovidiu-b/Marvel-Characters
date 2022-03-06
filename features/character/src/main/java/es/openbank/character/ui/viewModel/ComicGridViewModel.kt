package es.openbank.character.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import es.openbank.domain.character.GetCharacterComicsUseCase
import es.openbank.common.ui.BaseViewModel
import es.openbank.model.comicGrid.ComicBO
import es.openbank.common.wrappers.AsyncResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

class ComicGridViewModel @Inject constructor(
    private val getCharacterComicsUseCase: GetCharacterComicsUseCase,
    private val dispatcher: CoroutineDispatcher
): BaseViewModel() {

    private val comicsMutableLiveData: MutableLiveData<AsyncResult<List<ComicBO>>> = MutableLiveData(AsyncResult.LOADING())
    val comicsLiveData: LiveData<AsyncResult<List<ComicBO>>> = comicsMutableLiveData

    fun fetchComics(id: Int) {
        viewModelScope.launch(dispatcher) {
            comicsMutableLiveData.postValue(getCharacterComicsUseCase(id))
        }
    }

}