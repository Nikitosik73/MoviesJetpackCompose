package ru.mirea.moviesjetpackcompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.mirea.moviesjetpackcompose.domain.entity.MovieUI


@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    movieScreenContent: @Composable () -> Unit,
    movieDetailScreenContent: @Composable (MovieUI) -> Unit,
    favoriteMovieScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {

        homeScreenNavGraph(
            movieScreenContent = movieScreenContent,
            movieDetailScreenContent = movieDetailScreenContent
        )
        composable(route = Screen.FavoriteMovie.route) {
            favoriteMovieScreenContent()
        }
    }
}