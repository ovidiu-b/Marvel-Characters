package es.openbank.dev.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import es.openbank.dev.data.remote.AuthHashTest
import es.openbank.dev.TestApp
import es.openbank.dev.data.remote.di.RemoteTestModule
import es.openbank.dev.data.repository.CharactersRepositoryTest
import es.openbank.dev.data.repository.di.RepositoryTestModule
import es.openbank.dev.features.character.CharacterGridViewModelTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    TestAppModule::class,
    RemoteTestModule::class,
    RepositoryTestModule::class
])
interface TestAppComponent : AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: TestApp): Builder

        fun build(): TestAppComponent
    }

    fun inject(app: TestApp)
    fun inject(test: AuthHashTest)
    @ExperimentalCoroutinesApi
    fun inject(test: CharacterGridViewModelTest)
    @ExperimentalCoroutinesApi
    fun inject(test: CharactersRepositoryTest)
}