package ru.mirea.moviesjetpackcompose.domain.usecases

import kotlinx.coroutines.flow.StateFlow
import ru.mirea.moviesjetpackcompose.domain.entity.MovieUI
import ru.mirea.moviesjetpackcompose.domain.repository.MovieRepository
import javax.inject.Inject

class GetAllMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    operator fun invoke(): StateFlow<List<MovieUI>> = repository.getAllMovies()
}