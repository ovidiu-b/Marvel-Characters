package es.openbank.character.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import es.openbank.character.domain.GetCharacterUseCase
import es.openbank.common.ui.BaseViewModel
import es.openbank.model.characterGrid.CharacterBO
import es.openbank.repository.util.AppDispatchers
import es.openbank.repository.util.AsyncResult
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterDetailViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase,
    private val appDispatchers: AppDispatchers
): BaseViewModel() {

    private val characterMutableLiveData: MutableLiveData<AsyncResult<CharacterBO?>> = MutableLiveData(AsyncResult.loading())
    val characterLiveData: LiveData<AsyncResult<CharacterBO?>> = characterMutableLiveData

    fun fetchCharacter(id: Int) {
        viewModelScope.launch(appDispatchers.io) {
            characterMutableLiveData.postValue(getCharacterUseCase.invoke(id))
        }
    }

}