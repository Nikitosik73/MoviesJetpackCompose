package ru.paramonov.moviesjetpackcompose.domain.usecases

import kotlinx.coroutines.flow.StateFlow
import ru.paramonov.moviesjetpackcompose.domain.entity.MovieUI
import ru.paramonov.moviesjetpackcompose.domain.repository.MovieRepository

class GetAllMoviesUseCase(
    private val repository: MovieRepository
) {

    operator fun invoke(page: Int): StateFlow<List<MovieUI>> = repository.getAllMovies(page = page)
}