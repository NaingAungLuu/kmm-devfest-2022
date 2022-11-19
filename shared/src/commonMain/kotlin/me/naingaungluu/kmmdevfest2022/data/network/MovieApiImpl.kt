package me.naingaungluu.kmmdevfest2022.data.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.naingaungluu.kmmdevfest2022.data.models.MovieListResponse
import me.naingaungluu.kmmdevfest2022.data.models.MovieResponse

class MovieApiImpl(
    private val client: HttpClient
) : MovieApi {
    override fun getAllMovies(): Flow<List<MovieResponse>> = flow {
        val response = client.get("https://api.themoviedb.org/4/list/1")
            .body<MovieListResponse>()

        emit(response.results)
    }
}
