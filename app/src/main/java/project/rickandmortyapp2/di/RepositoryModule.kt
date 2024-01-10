package project.rickandmortyapp2.di

import project.rickandmortyapp2.data.repository.CharacterRepositoryImpl
import project.rickandmortyapp2.data.repository.CharactersRepositoryImpl
import project.rickandmortyapp2.domain.repository.CharacterRepository
import project.rickandmortyapp2.domain.repository.CharactersRepository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCharacterRepository(impl: CharacterRepositoryImpl): CharacterRepository

    @Binds
    abstract fun bindCharactersRepository(impl: CharactersRepositoryImpl): CharactersRepository
}