package ru.paramonov.moviesjetpackcompose.domain.usecases

import kotlinx.coroutines.flow.StateFlow
import ru.paramonov.moviesjetpackcompose.domain.entity.ReviewUI
import ru.paramonov.moviesjetpackcompose.domain.repository.MovieRepository

class GetReviewsUseCase(
    private val repository: MovieRepository
) {

    operator fun invoke(movieId: Int): StateFlow<List<ReviewUI>> =
        repository.getReviews(movieId = movieId)
}