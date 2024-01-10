package project.rickandmortyapp2.ui.characterDetails

import project.rickandmortyapp2.domain.model.Character

data class CharacterDetailState(
    val character: Character? = null,
    val isLoading: Boolean = false
)