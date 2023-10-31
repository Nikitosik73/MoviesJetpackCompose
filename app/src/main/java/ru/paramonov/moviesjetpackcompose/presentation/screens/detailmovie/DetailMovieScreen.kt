package ru.paramonov.moviesjetpackcompose.presentation.screens.detailmovie

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.paramonov.moviesjetpackcompose.domain.entity.MovieUI

@Composable
fun DetailMovieScreen(
    movieUI: MovieUI,
    paddingValues: PaddingValues,
    onBackPressure: () -> Unit
) {
    Box(modifier = Modifier.padding(paddingValues)) {
        Column {
            Text(text = "DetailMovieScreen")
            Button(onClick = { onBackPressure() }) {
                Text(text = "back")
            }
        }
    }
}