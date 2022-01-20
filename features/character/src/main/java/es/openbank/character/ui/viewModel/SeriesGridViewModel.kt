package es.openbank.character.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import es.openbank.character.domain.GetCharacterSeriesUseCase
import es.openbank.common.ui.BaseViewModel
import es.openbank.model.seriesGrid.SeriesBO
import es.openbank.repository.util.AppDispatchers
import es.openbank.repository.util.AsyncResult
import kotlinx.coroutines.launch
import javax.inject.Inject

class SeriesGridViewModel @Inject constructor(
    private val getCharacterSeriesUseCase: GetCharacterSeriesUseCase,
    private val appDispatchers: AppDispatchers
): BaseViewModel() {

    private val seriesMutableLiveData: MutableLiveData<AsyncResult<List<SeriesBO>>> = MutableLiveData(AsyncResult.loading())
    val seriesLiveData: LiveData<AsyncResult<List<SeriesBO>>> = seriesMutableLiveData

    fun fetchSeries(id: Int) {
        viewModelScope.launch(appDispatchers.io) {
            seriesMutableLiveData.postValue(getCharacterSeriesUseCase(id))
        }
    }
}