package ru.paramonov.moviesjetpackcompose.presentation.screens.favoritemovie

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FavoriteMoviesScreen(
    paddingValues: PaddingValues
) {
    Box(modifier = Modifier.padding(paddingValues)) {
        Text(text = "Favorite Movies Screen")
    }
}