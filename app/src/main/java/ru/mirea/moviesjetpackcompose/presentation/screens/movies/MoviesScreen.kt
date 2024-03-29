package ru.mirea.moviesjetpackcompose.presentation.screens.movies

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import ru.mirea.moviesjetpackcompose.domain.entity.MovieUI

@Composable
fun MoviesScreen(
    paddingValues: PaddingValues,
    onMovieClickListener: (MovieUI) -> Unit
) {
    Text(text = "MovieScreen")
}
