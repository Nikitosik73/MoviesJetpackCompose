package ru.mirea.moviesjetpackcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKScope
import ru.mirea.moviesjetpackcompose.domain.entity.AuthState
import ru.mirea.moviesjetpackcompose.presentation.app.getApplicationComponent
import ru.mirea.moviesjetpackcompose.presentation.screens.login.LoginScreen
import ru.mirea.moviesjetpackcompose.presentation.screens.login.LoginViewModel
import ru.mirea.moviesjetpackcompose.presentation.screens.mainscreen.MainScreen
import ru.mirea.moviesjetpackcompose.presentation.ui.theme.MoviesJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val component = getApplicationComponent()
            val viewModel: LoginViewModel = viewModel(factory = component.getViewModelFactory())
            val authViewState = viewModel.viewState.collectAsState(AuthState.Initial)

            val authLauncher = rememberLauncherForActivityResult(
                contract = VK.getVKAuthActivityResultContract(),
                onResult = { viewModel.performAuthResult() }
            )
            MoviesJetpackComposeTheme {
                when(authViewState.value) {
                    AuthState.Authorized -> {
                        MainScreen()
                    }
                    AuthState.NotAuthorized -> {
                        LoginScreen {
                            authLauncher.launch(listOf(VKScope.WALL, VKScope.FRIENDS))
                        }
                    }
                    AuthState.Initial -> {}
                }
            }
        }
    }
}