package es.openbank.dev.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import es.openbank.character.di.CharacterFragmentBuilder
import es.openbank.dev.App
import es.openbank.domain.di.DomainModule
import es.openbank.local.di.LocalModule
import es.openbank.remote.di.RemoteModule
import es.openbank.repository.di.RepositoryModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    LocalModule::class,
    RemoteModule::class,
    RepositoryModule::class,
    DomainModule::class,
    ActivityBuilder::class,
    CharacterFragmentBuilder::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}