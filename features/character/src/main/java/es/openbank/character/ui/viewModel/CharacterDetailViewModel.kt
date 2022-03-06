package es.openbank.character.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import es.openbank.domain.character.GetCharacterUseCase
import es.openbank.common.ui.BaseViewModel
import es.openbank.model.characterGrid.CharacterBO
import es.openbank.common.wrappers.AsyncResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterDetailViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase,
    private val dispatcher: CoroutineDispatcher
): BaseViewModel() {

    private val characterMutableLiveData: MutableLiveData<AsyncResult<CharacterBO?>> = MutableLiveData(AsyncResult.LOADING())
    val characterLiveData: LiveData<AsyncResult<CharacterBO?>> = characterMutableLiveData

    fun fetchCharacter(id: Int) {
        viewModelScope.launch(dispatcher) {
            characterMutableLiveData.postValue(getCharacterUseCase.invoke(id))
        }
    }

}