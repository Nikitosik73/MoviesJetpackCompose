package ru.paramonov.moviesjetpackcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.paramonov.moviesjetpackcompose.presentation.screens.login.LoginScreen
import ru.paramonov.moviesjetpackcompose.presentation.ui.theme.MoviesJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesJetpackComposeTheme {
                LoginScreen {

                }
            }
        }
    }
}