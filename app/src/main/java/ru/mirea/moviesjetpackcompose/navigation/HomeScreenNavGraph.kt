package ru.mirea.moviesjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.google.gson.Gson
import ru.mirea.moviesjetpackcompose.domain.entity.MovieUI

fun NavGraphBuilder.homeScreenNavGraph(
    moviesScreenContent: @Composable () -> Unit,
    detailMovieScreenContent: @Composable (MovieUI) -> Unit
) {

    navigation(
        startDestination = Screen.MovieScreen.route,
        route = Screen.Home.route
    ) {
        composable(route = Screen.MovieScreen.route) {
            moviesScreenContent()
        }
        composable(
            route = Screen.DetailMovieScreen.route,
            arguments = listOf(
                navArgument(name = Screen.MOVIE_ARGS) {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            val movieJson = navBackStackEntry.arguments?.getString(Screen.MOVIE_ARGS)
                ?: throw RuntimeException("Movie args is null")
            val movieUi = Gson().fromJson(movieJson, MovieUI::class.java)
            detailMovieScreenContent(movieUi)
        }
    }
}