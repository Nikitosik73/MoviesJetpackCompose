package ru.paramonov.moviesjetpackcompose.presentation.screens.mainscreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.paramonov.moviesjetpackcompose.domain.entity.MovieUI
import ru.paramonov.moviesjetpackcompose.navigation.AppNavGraph
import ru.paramonov.moviesjetpackcompose.navigation.NavigationState
import ru.paramonov.moviesjetpackcompose.navigation.Screen
import ru.paramonov.moviesjetpackcompose.navigation.rememberNavigateState
import ru.paramonov.moviesjetpackcompose.presentation.screens.detailmovie.DetailMovieScreen
import ru.paramonov.moviesjetpackcompose.presentation.screens.favoritemovie.FavoriteMoviesScreen
import ru.paramonov.moviesjetpackcompose.presentation.screens.movies.MoviesScreen
import ru.paramonov.moviesjetpackcompose.presentation.ui.theme.MoviesJetpackComposeTheme
import ru.paramonov.moviesjetpackcompose.presentation.ui.theme.YellowMovie

@Composable
fun MainScreen() {
    val navigationState = rememberNavigateState()

    Scaffold(
        bottomBar = { BottomNavBar(navigationState = navigationState) }
    ) { innerPadding ->
        AppNavGraph(
            navHostController = navigationState.navHostController,
            favoriteMovieContent = {
                FavoriteMoviesScreen(paddingValues = innerPadding)
            },
            moviesScreenContent = {
                MoviesScreen(
                    paddingValues = innerPadding,
                    onClickListener = {
                        navigationState.navigateToDetailScreen(it)
                    }
                )
            },
            detailMovieScreenContent = { movieUi ->
                DetailMovieScreen(
                    movieUI = movieUi,
                    paddingValues = innerPadding,
                    onBackPressure = { navigationState.navHostController.popBackStack() }
                )
            }
        )
    }
}

@Composable
private fun BottomNavBar(
    navigationState: NavigationState
) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Favorite
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
                    navigationState = navigationState,
                    item = item
                )
            }
        }
    }
}

@Composable
private fun BottomNavItem(
    navigationState: NavigationState,
    item: NavigationItem
) {
    val navBackStackEntry
            by navigationState.navHostController.currentBackStackEntryAsState()

    val selectedItem = navBackStackEntry?.destination?.hierarchy?.any {
        it.route == item.screen.route
    } == true

    val backgroundColor =
        if (selectedItem) YellowMovie else Color.Transparent

    val contentColor =
        if (selectedItem) Color.White else MaterialTheme.colorScheme.onSecondary

    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(shape = CircleShape)
            .background(color = backgroundColor)
            .clickable { navigationState.navigateTo(item.screen.route) },
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(space = 4.dp)
        ) {
            Icon(
                imageVector = if (selectedItem) item.selectedIcon else item.unselectedIcon,
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
