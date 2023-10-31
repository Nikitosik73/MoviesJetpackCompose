package ru.paramonov.moviesjetpackcompose.presentation.screens.mainscreen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import ru.paramonov.moviesjetpackcompose.navigation.AppNavGraph
import ru.paramonov.moviesjetpackcompose.navigation.NavigationState
import ru.paramonov.moviesjetpackcompose.navigation.rememberNavigateState

@Composable
fun MainScreen() {
    val navigationState = rememberNavigateState()

    Scaffold(
        bottomBar = { BottomNavBar(navigationState = navigationState) }
    ) { innerPadding ->
        AppNavGraph(
            navHostController = navigationState.navHostController,
            favoriteMovieContent = {

            },
            moviesScreenContent = {

            },
            detailMovieScreenContent = {

            }
        )
    }
}

@Composable
private fun BottomNavBar(
    navigationState: NavigationState
) {

}

@Composable
private fun BottomNavItem(
    navigationState: NavigationState,
    item: NavigationItem
) {

}