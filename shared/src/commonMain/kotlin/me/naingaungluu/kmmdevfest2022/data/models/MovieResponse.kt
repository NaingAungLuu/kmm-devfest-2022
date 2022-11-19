package me.naingaungluu.kmmdevfest2022.data.models

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class MovieResponse(

    @SerialName("id")
    val id: Int,

    @SerialName("title")
    val title: String? = null,

    @SerialName("overview")
    val description: String? = null,

    @SerialName("vote_average")
    val rating: Double? = null,

    @SerialName("poster_path")
    val posterPath: String? = null
)
