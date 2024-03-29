package ru.paramonov.moviesjetpackcompose.presentation.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import ru.mirea.moviesjetpackcompose.presentation.ui.theme.Black500
import ru.mirea.moviesjetpackcompose.presentation.ui.theme.Black900
import ru.mirea.moviesjetpackcompose.presentation.ui.theme.LightGray
import ru.mirea.moviesjetpackcompose.presentation.ui.theme.Typography

private val DarkColorScheme = darkColorScheme(
    primary = Black900,
    secondary = Black900,
    background = Color.Black,
    onPrimary = Color.White,
    onSecondary = Black500
)

private val LightColorScheme = lightColorScheme(
    primary = Color.White,
    secondary = Color.White,
    background = LightGray,
    onPrimary = Black900,
    onSecondary = Black500
)

@Composable
fun MoviesJetpackComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}