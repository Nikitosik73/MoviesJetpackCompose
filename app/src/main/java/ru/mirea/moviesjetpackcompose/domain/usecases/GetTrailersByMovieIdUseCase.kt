package ru.mirea.moviesjetpackcompose.domain.usecases

import kotlinx.coroutines.flow.StateFlow
import ru.mirea.moviesjetpackcompose.domain.entity.TrailerUI
import ru.mirea.moviesjetpackcompose.domain.repository.MovieRepository
import javax.inject.Inject

class GetTrailersByMovieIdUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    operator fun invoke(movieId: Int): StateFlow<List<TrailerUI>> =
        repository.getTrailersByMovieId(movieId = movieId)
}