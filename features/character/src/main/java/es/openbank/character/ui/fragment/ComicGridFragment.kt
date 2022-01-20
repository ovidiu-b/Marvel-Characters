package es.openbank.character.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.openbank.character.databinding.FragmentComicGridBinding
import es.openbank.character.ui.viewModel.ComicGridViewModel
import es.openbank.common.di.ViewModelFactory
import es.openbank.common.ui.BaseFragment
import es.openbank.common.ui.BaseViewModel
import javax.inject.Inject

class ComicGridFragment: BaseFragment() {

    companion object {
        private const val KEY_CHARACTER_ID = "character_id"

        fun newInstance(characterId: Int): ComicGridFragment {
            val fragment = ComicGridFragment()

            fragment.arguments = Bundle().apply {
                putInt(KEY_CHARACTER_ID, characterId)
            }

            return fragment
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<ComicGridViewModel>

    private val viewModel: ComicGridViewModel by lazy { viewModelFactory.get() }

    private lateinit var binding: FragmentComicGridBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentComicGridBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            if (it.containsKey(KEY_CHARACTER_ID)) {
                viewModel.fetchComics(it.getInt(KEY_CHARACTER_ID))
            }
        }
    }

    override fun getViewModel(): BaseViewModel = viewModel

}