package ru.paramonov.moviesjetpackcompose.domain.usecases

import ru.paramonov.moviesjetpackcompose.domain.repository.MovieRepository

class GetMoviesByNameUseCase(
    private val repository: MovieRepository
) {

    operator fun invoke(query: String) = repository.getMoviesByName(query = query)
}