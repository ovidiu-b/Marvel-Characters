package es.openbank.character.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import es.openbank.character.databinding.FragmentCharacterDetailBinding
import es.openbank.character.ui.adapter.CharacterDetailViewPagerAdapter
import es.openbank.character.ui.viewModel.CharacterDetailViewModel
import es.openbank.common.di.ViewModelFactory
import es.openbank.common.ui.BaseFragment
import es.openbank.common.ui.BaseViewModel
import es.openbank.model.characterGrid.CharacterBO
import es.openbank.common.wrappers.AsyncResult
import es.openbank.common.wrappers.isError
import javax.inject.Inject

class CharacterDetailFragment: BaseFragment() {

    private val args: CharacterDetailFragmentArgs by navArgs()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<CharacterDetailViewModel>

    private val viewModel: CharacterDetailViewModel by lazy { viewModelFactory.get() }

    private lateinit var binding: FragmentCharacterDetailBinding

    private val characterObserver = Observer<AsyncResult<CharacterBO?>> {
        if (it.isError()) {
            showErrorMessage("There was a problem fetching this character, please try again")
        }
    }

    private val tabList = arrayOf(
        "Comics",
        "Series",
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        binding.characterDetailViewPager.adapter = CharacterDetailViewPagerAdapter(args.id, childFragmentManager, lifecycle)

        TabLayoutMediator(binding.characterDetailTabLayout, binding.characterDetailViewPager) { tab, position ->
            tab.text = tabList[position]
        }.attach()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.characterLiveData.observe(viewLifecycleOwner, characterObserver)
        viewModel.fetchCharacter(args.id)
    }

    override fun getViewModel(): BaseViewModel = viewModel
}