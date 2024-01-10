package project.rickandmortyapp2.domain.repository

import project.rickandmortyapp2.common.Resource
import project.rickandmortyapp2.domain.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    fun getCharactersRepository(page: Int): Flow<Resource<List<Characters>>>

}