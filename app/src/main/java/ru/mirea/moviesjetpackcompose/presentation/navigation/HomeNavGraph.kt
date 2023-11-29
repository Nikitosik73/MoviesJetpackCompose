package ru.mirea.moviesjetpackcompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.google.gson.Gson
import ru.mirea.moviesjetpackcompose.domain.entity.MovieUI

fun NavGraphBuilder.homeScreenNavGraph(
    movieScreenContent: @Composable () -> Unit,
    movieDetailScreenContent: @Composable (MovieUI) -> Unit
) {
    navigation(
        startDestination = Screen.Movies.route,
        route = Screen.Home.route
    ) {
        composable(route = Screen.Movies.route) {
            movieScreenContent()
        }
        composable(
            route = Screen.MovieDetail.route,
            arguments = listOf(
                navArgument(name = Screen.KEY_MOVIE) {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            val movieJson = navBackStackEntry.arguments?.getString(Screen.KEY_MOVIE)
                ?: throw RuntimeException("Args is null")
            val movie = Gson().fromJson(movieJson, MovieUI::class.java)
            movieDetailScreenContent(movie)
        }
    }
}