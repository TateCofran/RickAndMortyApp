package project.rickandmortyapp2.domain.useCase

import project.rickandmortyapp2.common.Resource
import project.rickandmortyapp2.domain.model.Character
import project.rickandmortyapp2.domain.repository.CharacterRepository
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(id: Int): Resource<Character> {
        return repository.getCharacter(id)
    }
}