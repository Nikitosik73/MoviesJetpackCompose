package ru.mirea.moviesjetpackcompose.presentation.screens.movies

import ru.mirea.moviesjetpackcompose.domain.entity.MovieUI


sealed class MovieScreenState {

    object Initial : MovieScreenState()

    object Loading : MovieScreenState()

    data class MoviesContent(
        val listMovies: List<MovieUI>,
        val isNextDataLoading: Boolean
    ): MovieScreenState()
}
