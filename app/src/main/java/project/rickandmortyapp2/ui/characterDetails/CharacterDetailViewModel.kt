package project.rickandmortyapp2.ui.characterDetails

import project.rickandmortyapp2.common.Resource
import project.rickandmortyapp2.domain.useCase.GetCharacterUseCase

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(CharacterDetailState())
        private set

    init {
        getCharacter()
    }

    private fun getCharacter() {
        savedStateHandle.get<Int>("id")?.let { characterId ->
            viewModelScope.launch {
                getCharacterUseCase(characterId).also { result ->
                    when (result) {
                        is Resource.Success -> {
                            state = state.copy(
                                character = result.data,
                                isLoading = false
                            )
                        }
                        is Resource.Error -> {
                            state = state.copy(
                                isLoading = false
                            )
                        }
                        is Resource.Loading -> {
                            state = state.copy(
                                isLoading = true
                            )
                        }
                    }
                }
            }
        }
    }

}