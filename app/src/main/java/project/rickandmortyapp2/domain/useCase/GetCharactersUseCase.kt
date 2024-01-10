package project.rickandmortyapp2.domain.useCase

import project.rickandmortyapp2.common.Resource
import project.rickandmortyapp2.domain.model.Characters
import project.rickandmortyapp2.domain.repository.CharactersRepository

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
class GetCharactersUseCase @Inject constructor(
    private val repository: CharactersRepository
) {
    operator fun invoke(page:Int): Flow<Resource<List<Characters>>>{
        return repository.getCharactersRepository(page)
    }
}