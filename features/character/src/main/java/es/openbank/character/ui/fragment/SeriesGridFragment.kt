package es.openbank.character.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.openbank.character.databinding.FragmentSeriesGridBinding
import es.openbank.character.ui.viewModel.SeriesGridViewModel
import es.openbank.common.di.ViewModelFactory
import es.openbank.common.ui.BaseFragment
import es.openbank.common.ui.BaseViewModel
import javax.inject.Inject

class SeriesGridFragment: BaseFragment() {

    companion object {
        private const val KEY_CHARACTER_ID = "character_id"

        fun newInstance(characterId: Int): SeriesGridFragment {
            val fragment = SeriesGridFragment()

            fragment.arguments = Bundle().apply {
                putInt(KEY_CHARACTER_ID, characterId)
            }

            return fragment
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<SeriesGridViewModel>

    private val viewModel: SeriesGridViewModel by lazy { viewModelFactory.get() }

    private lateinit var binding: FragmentSeriesGridBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeriesGridBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            if (it.containsKey(KEY_CHARACTER_ID)) {
                viewModel.fetchSeries(it.getInt(KEY_CHARACTER_ID))
            }
        }

    }

    override fun getViewModel(): BaseViewModel = viewModel
}