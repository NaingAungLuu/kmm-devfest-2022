package me.naingaungluu.kmmdevfest2022.data.repositories

import kotlinx.coroutines.flow.Flow
import me.naingaungluu.kmmdevfest2022.data.network.MovieApi
import me.naingaungluu.kmmdevfest2022.domain.models.Movie
import me.naingaungluu.kmmdevfest2022.utils.mapList

class MovieRepositoryImpl(
    private val movieApi: MovieApi
) : MovieRepository {
    override fun getAllMovies(): Flow<List<Movie>> {
        return movieApi.getAllMovies().mapList {
            Movie(
                title = it.title.orEmpty(),
                description = it.description.orEmpty(),
                rating = it.rating ?: 0.0,
                isFavourite = false,
                imageUrl = "https://image.tmdb.org/t/p/w500${it.posterPath}"
            )
        }
    }
}
