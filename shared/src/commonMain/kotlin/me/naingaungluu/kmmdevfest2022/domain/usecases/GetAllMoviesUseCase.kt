package me.naingaungluu.kmmdevfest2022.domain.usecases

import kotlinx.coroutines.flow.Flow
import me.naingaungluu.kmmdevfest2022.data.network.KtorClient
import me.naingaungluu.kmmdevfest2022.data.network.MovieApiImpl
import me.naingaungluu.kmmdevfest2022.data.repositories.MovieRepository
import me.naingaungluu.kmmdevfest2022.data.repositories.MovieRepositoryImpl
import me.naingaungluu.kmmdevfest2022.domain.models.Movie

class GetAllMoviesUseCase(
    private val movieRepository: MovieRepository
) {
//    operator fun invoke(): Flow<List<Movie>> = movieRepository.getAllMovies()

    fun execute(): Flow<List<Movie>> = movieRepository.getAllMovies()

    companion object {
        val instance = GetAllMoviesUseCase(
            MovieRepositoryImpl(
                MovieApiImpl(
                    KtorClient.instance
                )
            )
        )
    }
}
