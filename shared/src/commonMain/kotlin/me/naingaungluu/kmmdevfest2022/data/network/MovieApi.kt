package me.naingaungluu.kmmdevfest2022.data.network

import kotlinx.coroutines.flow.Flow
import me.naingaungluu.kmmdevfest2022.data.models.MovieResponse

interface MovieApi {
    fun getAllMovies(): Flow<List<MovieResponse>>
}