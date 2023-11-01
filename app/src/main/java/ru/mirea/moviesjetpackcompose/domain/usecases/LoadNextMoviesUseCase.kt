package ru.mirea.moviesjetpackcompose.domain.usecases

import ru.mirea.moviesjetpackcompose.domain.repository.MovieRepository
import javax.inject.Inject

class LoadNextMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    suspend operator fun invoke() = repository.loadNextMovies()
}