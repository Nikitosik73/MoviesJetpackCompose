package ru.mirea.moviesjetpackcompose.presentation.screens.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector
import ru.paramonov.moviesjetpackcompose.R
import ru.mirea.moviesjetpackcompose.presentation.navigation.Screen

sealed class NavigationItem(
    val screen: Screen,
    val titleResId: Int,
    val selectedItem: ImageVector,
    val unselectedItem: ImageVector
) {
    object Home : NavigationItem(
        screen = Screen.Home,
        titleResId = R.string.home_screen,
        selectedItem = Icons.Rounded.Home,
        unselectedItem = Icons.Outlined.Home
    )

    object FavoriteMovie : NavigationItem(
        screen = Screen.FavoriteMovie,
        titleResId = R.string.favorite_screen,
        selectedItem = Icons.Rounded.Favorite,
        unselectedItem = Icons.Outlined.FavoriteBorder
    )
}
