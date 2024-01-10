package project.rickandmortyapp2.data.repository

import project.rickandmortyapp2.common.Resource
import project.rickandmortyapp2.data.dto.toCharacters
import project.rickandmortyapp2.data.remote.RickAndMortyApi
import project.rickandmortyapp2.domain.model.Characters
import project.rickandmortyapp2.domain.repository.CharactersRepository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
) : CharactersRepository {

    override fun getCharactersRepository(page: Int): Flow<Resource<List<Characters>>> = flow {
        emit(Resource.Loading())
        try {
            val response = api.getCharacters(page).toCharacters()
            emit(Resource.Success(response))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Oops, something went wrong",
                    data = null
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server, check your internet connection",
                    data = null
                )
            )
        }
    }
}