package es.openbank.character.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import es.openbank.character.domain.GetCharactersUseCase
import es.openbank.character.ui.fragment.CharacterGridFragmentDirections
import es.openbank.common.ui.BaseViewModel
import es.openbank.model.characterGrid.CharacterBO
import es.openbank.repository.util.AppDispatchers
import es.openbank.repository.util.AsyncResult
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterGridViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val dispatchers: AppDispatchers
) : BaseViewModel() {

    private val charactersMutableLiveData = MutableLiveData<AsyncResult<List<CharacterBO>>>(AsyncResult.loading())
    val charactersLiveData: LiveData<AsyncResult<List<CharacterBO>>> = charactersMutableLiveData

    fun requestCharacters(forceRequest: Boolean = false) {
        viewModelScope.launch(dispatchers.io) {
            charactersMutableLiveData.postValue(getCharactersUseCase(forceRequest))
        }
    }

    fun navigationToCharacterDetail(id: Int) {
        navigate(CharacterGridFragmentDirections.goToCharacterDetail(id))
    }
}