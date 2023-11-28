package ru.paramonov.moviesjetpackcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKScope
import ru.paramonov.moviesjetpackcompose.domain.entity.AuthState
import ru.paramonov.moviesjetpackcompose.presentation.app.getApplicationComponent
import ru.paramonov.moviesjetpackcompose.presentation.screens.login.LoginScreen
import ru.paramonov.moviesjetpackcompose.presentation.screens.login.LoginViewModel
import ru.paramonov.moviesjetpackcompose.presentation.screens.main.MovieMainScreen
import ru.paramonov.moviesjetpackcompose.presentation.ui.theme.MoviesJetpackComposeTheme

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
                        // аторизация прошла успешно
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            MovieMainScreen()
                        }
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