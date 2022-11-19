package me.naingaungluu.kmmdevfest2022.android.screens.movieList

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import me.naingaungluu.kmmdevfest2022.domain.models.Movie
import me.naingaungluu.kmmdevfest2022.domain.usecases.GetAllMoviesUseCase

class MovieListViewModel(
    private val getAllMovies: GetAllMoviesUseCase
) {
    private val _uiState: MutableStateFlow<MovieListScreenState> = MutableStateFlow(MovieListScreenState.Loading)
    val uiState: StateFlow<MovieListScreenState> = _uiState.asStateFlow()

    init {
        _uiState.value = MovieListScreenState.MovieListReady(
            getAllMovies.execute()
        )
    }
}

sealed class MovieListScreenState {
    data class MovieListReady(
        val state: Flow<List<Movie>>
    ) : MovieListScreenState()

    object Loading : MovieListScreenState()
}
