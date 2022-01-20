package es.openbank.dev.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import es.openbank.dev.NavigationHostActivity

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract fun bindNavHostActivity(): NavigationHostActivity
}