package project.rickandmortyapp2.domain.repository

import project.rickandmortyapp2.common.Resource
import project.rickandmortyapp2.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacter(id: Int): Resource<Character>

}