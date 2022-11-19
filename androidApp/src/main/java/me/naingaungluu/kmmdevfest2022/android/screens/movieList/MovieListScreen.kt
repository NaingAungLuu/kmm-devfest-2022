package me.naingaungluu.kmmdevfest2022.android.screens.movieList

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import me.naingaungluu.kmmdevfest2022.android.screens.destinations.MovieDetailScreenDestination
import me.naingaungluu.kmmdevfest2022.domain.models.Movie
import me.naingaungluu.kmmdevfest2022.domain.usecases.GetAllMoviesUseCase

@RootNavGraph(start = true) // sets this as the start destination of the default nav graph
@Destination
@Composable
fun MovieListScreen(
    viewModel: MovieListViewModel = MovieListViewModel(GetAllMoviesUseCase.instance),
    navigator: DestinationsNavigator
) {
    val uiState by viewModel.uiState.collectAsState(MovieListScreenState.Loading)

    Column {
        Text(
            text = "Movie List",
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(20.dp)
        )

        when (uiState) {
            MovieListScreenState.Loading -> {
                LoadingLayout()
            }
            is MovieListScreenState.MovieListReady -> {
                val movieList = (uiState as MovieListScreenState.MovieListReady).state.collectAsState(emptyList())

                if (movieList.value.isEmpty()) {
                    LoadingLayout()
                } else {
                    MovieListLayout(
                        data = movieList.value,
                        onTapItem = {
                            navigator.navigate(MovieDetailScreenDestination)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun LoadingLayout() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Loading")
    }
}

@Composable
fun MovieListLayout(
    data: List<Movie>,
    onTapItem: (Movie) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize().then(modifier),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(data) {
            MovieListItem(
                data = it,
                onTapItem = onTapItem
            )
        }
    }
}

@Composable
fun MovieListItem(
    data: Movie,
    onTapItem: (Movie) -> Unit
) {
    Column(
        Modifier.fillMaxSize()
            .padding(horizontal = 10.dp)
            .clickable {
                onTapItem(data)
            }
    ) {
        AsyncImage(
            model = data.imageUrl,
            contentDescription = "Cover art",
            modifier = Modifier.clip(RoundedCornerShape(10.dp))
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = data.title,
            fontWeight = FontWeight.Bold,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(horizontal = 8.dp)
        )
        Text(
            text = data.rating.toString(),
            modifier = Modifier.align(Alignment.End)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xffffcc33))
                .padding(horizontal = 4.dp, vertical = 2.dp)

        )
        Spacer(Modifier.height(16.dp))
    }
}
