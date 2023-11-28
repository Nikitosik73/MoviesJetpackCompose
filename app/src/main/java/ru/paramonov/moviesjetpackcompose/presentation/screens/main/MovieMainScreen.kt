package ru.paramonov.moviesjetpackcompose.presentation.screens.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.paramonov.moviesjetpackcompose.presentation.navigation.AppNavGraph
import ru.paramonov.moviesjetpackcompose.presentation.navigation.AppNavigationState
import ru.paramonov.moviesjetpackcompose.presentation.navigation.rememberAppNavigationState
import ru.paramonov.moviesjetpackcompose.presentation.screens.detailmovie.DetailMovieScreen
import ru.paramonov.moviesjetpackcompose.presentation.screens.favoritemovie.FavoriteMovieScreen
import ru.paramonov.moviesjetpackcompose.presentation.screens.movies.MoviesScreen
import ru.paramonov.moviesjetpackcompose.presentation.ui.theme.VkDefault

@Composable
fun MovieMainScreen() {
    val appNavigationState = rememberAppNavigationState()

    Scaffold(
        bottomBar = { BottomNavBar(appNavigationState = appNavigationState) }
    ) { innerPadding ->
        AppNavGraph(
            navHostController = appNavigationState.navHostController,
            movieScreenContent = {
                MoviesScreen(
                    paddingValues = innerPadding,
                    onMovieClickListener = { movie ->
                        appNavigationState.navigateToMovieDetailScreen(movie = movie)
                    }
                )
            },
            movieDetailScreenContent = { movie ->
                DetailMovieScreen(
                    paddingValues = innerPadding,
                    movieUI = movie
                )
            },
            favoriteMovieScreenContent = { FavoriteMovieScreen(paddingValues = innerPadding) }
        )
    }
}

@Composable
private fun BottomNavBar(appNavigationState: AppNavigationState) {

    val items = listOf(
        NavigationItem.Home,
        NavigationItem.FavoriteMovie
    )

    Row(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 10.dp)
            .clip(shape = CircleShape)
            .background(color = MaterialTheme.colorScheme.secondary)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items.forEach { item ->
                BottomNavItem(
                    appNavigationState = appNavigationState,
                    item = item
                )
            }
        }
    }
}

@Composable
private fun BottomNavItem(
    appNavigationState: AppNavigationState,
    item: NavigationItem,
) {
    val navBackStackEntry
            by appNavigationState.navHostController.currentBackStackEntryAsState()

    val selectedItem = navBackStackEntry?.destination?.hierarchy?.any {
        it.route == item.screen.route
    } == true

    val background =
        if (selectedItem) VkDefault else Color.Transparent

    val contentColor =
        if (selectedItem) Color.White else MaterialTheme.colorScheme.onSecondary

    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(shape = CircleShape)
            .background(color = background)
            .clickable { appNavigationState.navigateToScreen(item.screen.route) },
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                imageVector = if (selectedItem) item.selectedItem else item.unselectedItem,
                contentDescription = null,
                tint = contentColor
            )
            AnimatedVisibility(visible = selectedItem) {
                Text(
                    text = stringResource(id = item.titleResId),
                    color = contentColor
                )
            }
        }
    }
}