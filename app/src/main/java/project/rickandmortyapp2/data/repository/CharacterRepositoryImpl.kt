package project.rickandmortyapp2.data.repository

import project.rickandmortyapp2.common.Resource
import project.rickandmortyapp2.data.dto.toCharacter
import project.rickandmortyapp2.data.remote.RickAndMortyApi
import project.rickandmortyapp2.domain.model.Character
import project.rickandmortyapp2.domain.repository.CharacterRepository

import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
) : CharacterRepository {

    override suspend fun getCharacter(id: Int): Resource<Character> {
        val response = try {
            api.getCharacter(id).toCharacter()
        } catch (e: Exception) {
            return Resource.Error(
                message = "An unknown error occurred"
            )
        }
        return Resource.Success(response)
    }
}