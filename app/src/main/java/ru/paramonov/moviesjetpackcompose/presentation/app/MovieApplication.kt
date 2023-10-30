package ru.paramonov.moviesjetpackcompose.presentation.app

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import ru.paramonov.moviesjetpackcompose.di.component.ApplicationComponent
import ru.paramonov.moviesjetpackcompose.di.component.DaggerApplicationComponent

class MovieApplication : Application() {

    val component by lazy {
        DaggerApplicationComponent
            .factory()
            .create(context = this)
    }
}

@Composable
fun getApplicationComponent(): ApplicationComponent {
    return (LocalContext.current.applicationContext as MovieApplication).component
}