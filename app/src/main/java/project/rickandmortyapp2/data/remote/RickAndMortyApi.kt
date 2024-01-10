package project.rickandmortyapp2.data.remote

import project.rickandmortyapp2.data.dto.CharactersDto
import project.rickandmortyapp2.data.dto.Result
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("character/")
    suspend fun getCharacters(
        @Query("page") page: Int
    ): CharactersDto

    @GET("character/{id}")
    suspend fun getCharacter(
        @Path("id") id: Int
    ): Result
}