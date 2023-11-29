package ru.mirea.moviesjetpackcompose.presentation.navigation

import android.net.Uri
import com.google.gson.Gson
import ru.mirea.moviesjetpackcompose.domain.entity.MovieUI

sealed class Screen(
    val route: String
) {

    object Home : Screen(route = HOME_SCREEN)

    object Movies : Screen(route = MOVIES_SCREEN)

    object MovieDetail : Screen(route = MOVIE_DETAIL_SCREEN) {

        private const val ROUTE_MOVIE_DETAIL_ARGS = "movie_detail"

        fun getRouteMovieDetailWithArgs(movie: MovieUI): String {
            val movieJson = Gson().toJson(movie).encode()
            return "$ROUTE_MOVIE_DETAIL_ARGS/$movieJson"
        }
    }

    object FavoriteMovie : Screen(route = FAVORITE_MOVIE_SCREEN)

    companion object {
        // args
        const val KEY_MOVIE = "movie"

        // route screen
        private const val HOME_SCREEN = "home"
        private const val MOVIES_SCREEN = "movies"
        private const val MOVIE_DETAIL_SCREEN = "movie_detail/{$KEY_MOVIE}"
        private const val FAVORITE_MOVIE_SCREEN = "favorite_movie"
    }
}

private fun String.encode() = Uri.encode(this)