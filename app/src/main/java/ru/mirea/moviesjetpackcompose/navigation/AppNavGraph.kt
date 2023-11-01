package ru.mirea.moviesjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.mirea.moviesjetpackcompose.domain.entity.MovieUI

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    favoriteMovieContent: @Composable () -> Unit,
    moviesScreenContent: @Composable () -> Unit,
    detailMovieScreenContent: @Composable (MovieUI) -> Unit
) {

    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {

        homeScreenNavGraph(
            moviesScreenContent = moviesScreenContent,
            detailMovieScreenContent = detailMovieScreenContent
        )
        composable(route = Screen.FavoriteMovieScreen.route) {
            favoriteMovieContent()
        }
    }
}