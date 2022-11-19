package me.naingaungluu.kmmdevfest2022.data.repositories

import kotlinx.coroutines.flow.Flow
import me.naingaungluu.kmmdevfest2022.domain.models.Movie

interface MovieRepository {
    fun getAllMovies(): Flow<List<Movie>>
}