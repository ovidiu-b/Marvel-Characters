package es.openbank.character.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import es.openbank.domain.character.GetCharacterSeriesUseCase
import es.openbank.common.ui.BaseViewModel
import es.openbank.model.seriesGrid.SeriesBO
import es.openbank.common.wrappers.AsyncResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

class SeriesGridViewModel @Inject constructor(
    private val getCharacterSeriesUseCase: GetCharacterSeriesUseCase,
    private val dispatcher: CoroutineDispatcher
): BaseViewModel() {

    private val seriesMutableLiveData: MutableLiveData<AsyncResult<List<SeriesBO>>> = MutableLiveData(AsyncResult.LOADING())
    val seriesLiveData: LiveData<AsyncResult<List<SeriesBO>>> = seriesMutableLiveData

    fun fetchSeries(id: Int) {
        viewModelScope.launch(dispatcher) {
            seriesMutableLiveData.postValue(getCharacterSeriesUseCase(id))
        }
    }
}