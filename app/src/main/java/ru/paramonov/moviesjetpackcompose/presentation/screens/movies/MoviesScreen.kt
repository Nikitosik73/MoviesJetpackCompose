package ru.paramonov.moviesjetpackcompose.presentation.screens.movies

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
fun MoviesScreen(
    paddingValues: PaddingValues,
    onClickListener: (MovieUI) -> Unit
) {
    Box(
        modifier = Modifier.padding(paddingValues)
    ) {
        val movie = MovieUI(
            id = 1,
            name = "asjkjaskld",
            description = "fajkldjakl",
            year = 2212,
            poster = "asjfklaskfa",
            rating = 2.0
        )

        Column {
            Text(text = "Screen Movies")
            Button(onClick = { onClickListener(movie) }) {
                Text(text = "go to detail")
            }
        }
    }
}