package ru.mirea.moviesjetpackcompose.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.mirea.moviesjetpackcompose.di.annotation.ViewModelKey
import ru.mirea.moviesjetpackcompose.presentation.screens.login.LoginViewModel
import ru.mirea.moviesjetpackcompose.presentation.screens.movies.MovieViewModel

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(value = LoginViewModel::class)
    fun bindLoginViewModel(
        impl: LoginViewModel
    ): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(value = MovieViewModel::class)
    fun bindMovieViewModel(
        impl: MovieViewModel
    ): ViewModel
}