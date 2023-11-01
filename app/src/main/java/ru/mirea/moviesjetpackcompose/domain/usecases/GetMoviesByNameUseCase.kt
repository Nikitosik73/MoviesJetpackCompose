package ru.mirea.moviesjetpackcompose.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.mirea.moviesjetpackcompose.domain.entity.MovieUI
import ru.mirea.moviesjetpackcompose.domain.repository.MovieRepository
import javax.inject.Inject

class GetMoviesByNameUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    operator fun invoke(query: String): Flow<List<MovieUI>> =
        repository.getMoviesByName(query = query)
}