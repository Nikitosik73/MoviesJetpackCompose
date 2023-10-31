package ru.paramonov.moviesjetpackcompose.navigation

import android.net.Uri
import com.google.gson.Gson
import ru.paramonov.moviesjetpackcompose.domain.entity.MovieUI

sealed class Screen(
    val route: String
) {

    object Home : Screen(route = HOME_SCREEN)

    object MovieScreen : Screen(route = MOVIE_SCREEN)

    object FavoriteMovieScreen : Screen(route = FAVORITE_MOVIE_SCREEN)

    object DetailMovieScreen : Screen(route = DETAIL_MOVIE_SCREEN) {

        private const val MOVIE_ROUTE_FOR_ARGS = "detail_movie_screen"

        fun getRouteWithArgs(movie: MovieUI): String {
            val movieJson = Gson().toJson(movie).encode()
            return "$MOVIE_ROUTE_FOR_ARGS/$movie"
        }
    }

    companion object {
        const val MOVIE_ARGS = "movie"

        private const val HOME_SCREEN = "home_screen"
        private const val MOVIE_SCREEN = "movie_screen"
        private const val FAVORITE_MOVIE_SCREEN = "favorite_movie_screen"
        private const val DETAIL_MOVIE_SCREEN = "detail_movie_screen/{$MOVIE_ARGS}"
    }
}

private fun String.encode() = Uri.encode(this)