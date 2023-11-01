package ru.mirea.moviesjetpackcompose.domain.usecases

import kotlinx.coroutines.flow.StateFlow
import ru.mirea.moviesjetpackcompose.domain.entity.ReviewUI
import ru.mirea.moviesjetpackcompose.domain.repository.MovieRepository
import javax.inject.Inject

class GetReviewsUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    operator fun invoke(movieId: Int): StateFlow<List<ReviewUI>> =
        repository.getReviews(movieId = movieId)
}