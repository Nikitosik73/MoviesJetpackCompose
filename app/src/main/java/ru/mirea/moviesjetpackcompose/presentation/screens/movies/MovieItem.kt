package ru.mirea.moviesjetpackcompose.presentation.screens.movies

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import ru.mirea.moviesjetpackcompose.domain.entity.MovieUI
import ru.mirea.moviesjetpackcompose.presentation.ui.theme.MoviesJetpackComposeTheme

@Composable
fun MovieItem(
    movieUI: MovieUI,
    onMovieClickListener: (MovieUI) -> Unit
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onMovieClickListener(movieUI) }
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = movieUI.poster,
                contentDescription = "Poster Movie",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = movieUI.rating.toString(),
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .background(Color(0xFF4CAF50))
                        .padding(8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewModeMovieItem() {
    MoviesJetpackComposeTheme(
        darkTheme = false
    ) {
        MovieItem(
            movieUI = MovieUI(
                id = 1,
                name = "fajklsfjaskf",
                description = "fsajkfjaskf",
                year = 2442,
                poster = "https://avatars.mds.yandex.net/get-kinopoisk-image/1898899/972b7f43-9677-40ce-a9bc-02a88ad3919d/orig",
                rating = 10.0
            ),
            onMovieClickListener = {}
        )
    }
}