package ru.paramonov.moviesjetpackcompose.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import ru.paramonov.moviesjetpackcompose.domain.entity.MovieUI
import ru.paramonov.moviesjetpackcompose.domain.repository.MovieRepository
import javax.inject.Inject

class GetMoviesByNameUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    operator fun invoke(query: String): Flow<List<MovieUI>> =
        repository.getMoviesByName(query = query)
}