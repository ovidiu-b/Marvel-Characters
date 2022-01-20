package es.openbank.character.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import es.openbank.character.databinding.FragmentCharacterGridBinding
import es.openbank.character.ui.adapter.RowItemClickListener
import es.openbank.character.ui.viewModel.CharacterGridViewModel
import es.openbank.common.di.ViewModelFactory
import es.openbank.common.ui.BaseFragment
import es.openbank.common.ui.BaseViewModel
import es.openbank.model.characterGrid.CharacterBO
import es.openbank.repository.util.AsyncResult
import javax.inject.Inject

class CharacterGridFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<CharacterGridViewModel>

    private val viewModel: CharacterGridViewModel by lazy { viewModelFactory.get() }

    private lateinit var binding: FragmentCharacterGridBinding

    private val charactersObserver = Observer<AsyncResult<List<CharacterBO>>> {
        if (it.status == AsyncResult.Status.ERROR) {
            showErrorMessage(it.error?.message ?: "There was a problem fetching the characters, please try again")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCharacterGridBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.listener = getClickListener()
        return binding.root
    }

    private fun getClickListener() = object: RowItemClickListener {
        override fun onItemClicked(id: Int) {
            viewModel.navigationToCharacterDetail(id)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.charactersLiveData.observe(viewLifecycleOwner, charactersObserver)
        viewModel.requestCharacters()
        binding.characterGridSwipeRefresh.setOnRefreshListener { viewModel.requestCharacters(true) }
    }

    override fun getViewModel(): BaseViewModel = viewModel
}