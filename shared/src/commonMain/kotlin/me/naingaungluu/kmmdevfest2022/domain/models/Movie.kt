package me.naingaungluu.kmmdevfest2022.domain.models

@kotlinx.serialization.Serializable
data class Movie(
    val title: String,
    val description: String,
    val rating: Double,
    val isFavourite: Boolean = false,
    val imageUrl: String = ""
)
