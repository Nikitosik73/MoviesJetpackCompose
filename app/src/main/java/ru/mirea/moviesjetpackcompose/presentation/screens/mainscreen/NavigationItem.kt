package ru.mirea.moviesjetpackcompose.presentation.screens.mainscreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector

import ru.mirea.moviesjetpackcompose.navigation.Screen
import ru.paramonov.moviesjetpackcompose.R

sealed class NavigationItem(
    val screen: Screen,
    val titleResId: Int,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {

    object Home : NavigationItem(
        screen = Screen.Home,
        titleResId = R.string.home,
        selectedIcon = Icons.Rounded.Home,
        unselectedIcon = Icons.Outlined.Home
    )

    object Favorite : NavigationItem(
        screen = Screen.FavoriteMovieScreen,
        titleResId = R.string.favorite,
        selectedIcon = Icons.Rounded.Favorite,
        unselectedIcon = Icons.Outlined.FavoriteBorder
    )
}