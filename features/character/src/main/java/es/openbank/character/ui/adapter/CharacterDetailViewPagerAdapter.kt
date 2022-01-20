package es.openbank.character.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import es.openbank.character.ui.fragment.ComicGridFragment
import es.openbank.character.ui.fragment.SeriesGridFragment

private const val NUM_TABS = 2

class CharacterDetailViewPagerAdapter(
    private val characterId: Int,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = NUM_TABS

    override fun createFragment(position: Int): Fragment {
        if (position == 0) {
            return ComicGridFragment.newInstance(characterId)
        }

        return SeriesGridFragment.newInstance(characterId)
    }

}