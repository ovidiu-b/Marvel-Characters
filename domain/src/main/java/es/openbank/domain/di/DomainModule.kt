package es.openbank.domain.di

import dagger.Module
import dagger.Provides
import es.openbank.domain.character.GetCharactersUseCase
import es.openbank.repository.characters.CharactersRepository

@Module
class DomainModule {

    @Provides
    fun provideGetCharactersUseCase(repository: CharactersRepository) = GetCharactersUseCase(repository)

}