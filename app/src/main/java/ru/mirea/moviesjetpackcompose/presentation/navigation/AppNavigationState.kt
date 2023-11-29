package ru.mirea.moviesjetpackcompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.mirea.moviesjetpackcompose.domain.entity.MovieUI

class AppNavigationState(
    val navHostController: NavHostController
) {

    fun navigateToScreen(route: String) {
        navHostController.navigate(route = route) {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateToMovieDetailScreen(movie: MovieUI) {
        navHostController
            .navigate(route = Screen.MovieDetail.getRouteMovieDetailWithArgs(movie = movie))
    }
}

@Composable
fun rememberAppNavigationState(
    navHostController: NavHostController = rememberNavController()
): AppNavigationState = remember {
    AppNavigationState(navHostController = navHostController)
}