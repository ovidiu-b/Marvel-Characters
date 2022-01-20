package es.openbank.character.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import es.openbank.character.domain.GetCharacterComicsUseCase
import es.openbank.common.ui.BaseViewModel
import es.openbank.model.comicGrid.ComicBO
import es.openbank.repository.util.AppDispatchers
import es.openbank.repository.util.AsyncResult
import kotlinx.coroutines.launch
import javax.inject.Inject

class ComicGridViewModel @Inject constructor(
    private val getCharacterComicsUseCase: GetCharacterComicsUseCase,
    private val appDispatchers: AppDispatchers
): BaseViewModel() {

    private val comicsMutableLiveData: MutableLiveData<AsyncResult<List<ComicBO>>> = MutableLiveData(AsyncResult.loading())
    val comicsLiveData: LiveData<AsyncResult<List<ComicBO>>> = comicsMutableLiveData

    fun fetchComics(id: Int) {
        viewModelScope.launch(appDispatchers.io) {
            comicsMutableLiveData.postValue(getCharacterComicsUseCase(id))
        }
    }

}