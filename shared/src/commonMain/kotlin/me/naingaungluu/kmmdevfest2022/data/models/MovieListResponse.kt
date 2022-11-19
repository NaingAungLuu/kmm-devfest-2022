package me.naingaungluu.kmmdevfest2022.data.models

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class MovieListResponse(
    @SerialName("results")
    val results: List<MovieResponse> = emptyList()
)
