package ru.mirea.moviesjetpackcompose.presentation.screens.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.mirea.moviesjetpackcompose.domain.entity.MovieUI

import ru.mirea.moviesjetpackcompose.presentation.app.getApplicationComponent
import ru.mirea.moviesjetpackcompose.presentation.ui.theme.YellowMovie
import ru.paramonov.moviesjetpackcompose.R

@Composable
fun MoviesScreen(
    paddingValues: PaddingValues,
    onMoviesClickListener: (MovieUI) -> Unit
) {
    val component = getApplicationComponent()
    val viewModel: MovieViewModel = viewModel(factory = component.getViewModelFactory())
    val viewState = viewModel.viewStateMovies.collectAsState(initial = MovieViewState.Initial)

    MoviesContent(
        viewState = viewState,
        onMoviesClickListener = onMoviesClickListener,
        viewModel = viewModel,
        paddingValues = paddingValues
    )
}

@Composable
private fun MoviesContent(
    viewState: State<MovieViewState>,
    onMoviesClickListener: (MovieUI) -> Unit,
    viewModel: MovieViewModel,
    paddingValues: PaddingValues
) {
    when (val currentViewState = viewState.value) {
        is MovieViewState.ContentMovies -> {
            MoviesList(
                paddingValues = paddingValues,
                viewModel = viewModel,
                moviesList = currentViewState.data,
                onMoviesClickListener = onMoviesClickListener,
                nextDataLoading = currentViewState.isLoading
            )
        }

        is MovieViewState.Loading -> {
            LoadingBar()
        }

        is MovieViewState.Initial -> {

        }
    }
}

@Composable
private fun LoadingBar() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(color = YellowMovie)
    }
}

@Composable
private fun MoviesList(
    paddingValues: PaddingValues,
    viewModel: MovieViewModel,
    moviesList: List<MovieUI>,
    onMoviesClickListener: (MovieUI) -> Unit,
    nextDataLoading: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = stringResource(id = R.string.movies),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
        LazyVerticalGrid(
            modifier = Modifier.padding(paddingValues),
            contentPadding = PaddingValues(
                top = 8.dp, bottom = 16.dp,
                end = 8.dp, start = 8.dp
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            columns = GridCells.Fixed(count = 2),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = moviesList,
                key = { movie -> movie.id }
            ) { movie ->
                MovieItem(movieUI = movie, onMovieClickListener = onMoviesClickListener)
            }
        }
        if (nextDataLoading) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = YellowMovie)
            }
        } else {
            SideEffect {
                viewModel.loadNextDataMovies()
            }
        }
    }
}
