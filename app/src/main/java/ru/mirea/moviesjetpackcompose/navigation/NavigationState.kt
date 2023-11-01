package ru.mirea.moviesjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.mirea.moviesjetpackcompose.domain.entity.MovieUI

class NavigationState(
    val navHostController: NavHostController
) {

    fun navigateTo(route: String) {
        navHostController.navigate(route = route) {
            popUpTo (navHostController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateToDetailScreen(movie: MovieUI) {
        navHostController.navigate(route = Screen.DetailMovieScreen.getRouteWithArgs(movie = movie))
    }
}

@Composable
fun rememberNavigateState(
    navHostController: NavHostController = rememberNavController()
): NavigationState = remember {
    NavigationState(navHostController = navHostController)
}
