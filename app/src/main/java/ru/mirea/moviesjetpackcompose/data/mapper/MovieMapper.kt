package ru.mirea.moviesjetpackcompose.data.mapper

import ru.mirea.moviesjetpackcompose.data.network.model.movie.MovieResponseDto
import ru.mirea.moviesjetpackcompose.data.network.model.review.ReviewResponseDto
import ru.mirea.moviesjetpackcompose.data.network.model.trailer.TrailerResponseDto
import ru.mirea.moviesjetpackcompose.domain.entity.MovieUI
import ru.mirea.moviesjetpackcompose.domain.entity.ReviewUI
import ru.mirea.moviesjetpackcompose.domain.entity.TrailerUI
import javax.inject.Inject

class MovieMapper @Inject constructor() {

    fun mapReviewDtoToReviewUi(response: ReviewResponseDto): List<ReviewUI> {

        val result = mutableListOf<ReviewUI>()

        val reviews = response.contentReviewResponse

        reviews.forEach { dtoReview ->
            val reviewUi = ReviewUI(
                id = dtoReview.id,
                title = dtoReview.title,
                review = dtoReview.review,
                author = dtoReview.author,
                typeReview = dtoReview.typeReview
            )
            result.add(reviewUi)
        }

        return result
    }

    fun mapTrailersDtoToTrailersUi(response: TrailerResponseDto): List<TrailerUI> {

        val result = mutableListOf<TrailerUI>()

        val trailers = response.contentTrailerResponse.video.listTrailersUrl

        trailers.forEach { trailerDto ->
            val trailerUi = TrailerUI(
                trailerUrl = trailerDto.trailerUrl
            )
            result.add(trailerUi)
        }

        return result
    }

    fun mapMovieDtoToMovieUi(response: MovieResponseDto): List<MovieUI> {

        val result = mutableListOf<MovieUI>()

        val movies = response.contentMovieList

        movies.forEach { movieDto ->
            val movieUi = MovieUI(
                id = movieDto.id,
                name = movieDto.name,
                description = movieDto.description,
                year = movieDto.year,
                poster = movieDto.poster.posterUrl,
                rating = movieDto.rating.ratingMovie
            )
            result.add(movieUi)
        }
        return result
    }
}