package project.rickandmortyapp2.domain.model

import project.rickandmortyapp2.data.dto.Location
import project.rickandmortyapp2.data.dto.Origin

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String
)