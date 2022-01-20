package es.openbank.character.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import es.openbank.character.ui.fragment.CharacterGridFragment
import es.openbank.character.ui.fragment.CharacterDetailFragment
import es.openbank.character.ui.fragment.ComicGridFragment
import es.openbank.character.ui.fragment.SeriesGridFragment

@Module
abstract class CharacterFragmentBuilder {

    @ContributesAndroidInjector
    abstract fun bindCharactersGridFragment(): CharacterGridFragment

    @ContributesAndroidInjector
    abstract fun bindCharactersDetailFragment(): CharacterDetailFragment

    @ContributesAndroidInjector
    abstract fun bindComicGridFragment(): ComicGridFragment

    @ContributesAndroidInjector
    abstract fun bindSeriesGridFragment(): SeriesGridFragment

}