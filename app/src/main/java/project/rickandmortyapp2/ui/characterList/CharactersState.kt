package project.rickandmortyapp2.ui.characterList

import project.rickandmortyapp2.domain.model.Characters

data class CharactersState(
    val characters: List<Characters> = emptyList(),
    val isLoading : Boolean = false,
    val showPrevious: Boolean = false,
    val showNext: Boolean = false,
    )