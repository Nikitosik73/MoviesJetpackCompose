package ru.mirea.moviesjetpackcompose.presentation.screens.movies

import ru.mirea.moviesjetpackcompose.domain.entity.MovieUI

sealed class MovieViewState{

    object Initial : MovieViewState()

    object Loading : MovieViewState()

    class ContentMovies(
        val data: List<MovieUI>,
        val isLoading: Boolean = false
    ) : MovieViewState()
}
