package project.rickandmortyapp2.data.dto

import project.rickandmortyapp2.domain.model.Character

data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun Result.toCharacter(): Character {
    return Character(
        id = id,
        name = name,
        status = status,
        species = species,
        gender = gender,
        origin = origin,
        location = location,
        image = image
    )
}