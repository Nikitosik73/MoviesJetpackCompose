package ru.paramonov.moviesjetpackcompose.domain.usecases

import kotlinx.coroutines.flow.StateFlow
import ru.paramonov.moviesjetpackcompose.domain.entity.MovieUI
import ru.paramonov.moviesjetpackcompose.domain.repository.MovieRepository

class GetMoviesByNameUseCase(
    private val repository: MovieRepository
) {

    operator fun invoke(query: String): StateFlow<List<MovieUI>> =
        repository.getMoviesByName(query = query)
}