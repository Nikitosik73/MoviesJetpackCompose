package ru.mirea.moviesjetpackcompose.presentation.screens.detailmovie

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import ru.mirea.moviesjetpackcompose.domain.entity.MovieUI

@Composable
fun DetailMovieScreen(
    movieUI: MovieUI,
    paddingValues: PaddingValues
) {
    Text(text = "DetailMovieScreen", fontSize = 36.sp)
}