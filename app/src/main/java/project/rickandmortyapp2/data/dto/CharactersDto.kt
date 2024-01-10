package project.rickandmortyapp2.data.dto

import project.rickandmortyapp2.domain.model.Characters

data class CharactersDto(
    val info: Info,
    val results: List<Result>
)

fun CharactersDto.toCharacters(): List<Characters> {
    val resultEntries = results.mapIndexed { _, entries ->
        Characters(
            id = entries.id,
            name = entries.name,
            specie = entries.species,
            image = entries.image
        )
    }
    return resultEntries
}