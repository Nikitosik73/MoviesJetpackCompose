package ru.paramonov.moviesjetpackcompose.data.network.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.paramonov.moviesjetpackcompose.data.network.model.movie.MovieResponseDto
import ru.paramonov.moviesjetpackcompose.data.network.model.review.ReviewResponseDto

interface ApiService {

    @GET("v1.3/movie?search=4-8")
    suspend fun getAllMoviesResponse(
        @Query(TOKEN) token: String = TOKEN_VALUE,
        @Query(FIELD) field: String = "rating.kp",
        @Query(SORT_FIELD) sortField: String = "votes.kp",
        @Query(SORT_TYPE) sortType: String = "-1",
        @Query(LIMIT) limit: Int = 20,
        @Query(PAGE) page: Int
    ): MovieResponseDto

    @GET("v1/review")
    suspend fun getAllReviewsResponse(
        @Query(TOKEN) token: String = TOKEN_VALUE,
        @Query(MOVIE_ID) movieId: Int
    ): ReviewResponseDto

    @GET("v1.2/movie/search")
    suspend fun getMoviesByName(
        @Query(TOKEN) token: String = TOKEN_VALUE,
        @Query(QUERY) query: String
    ): MovieResponseDto

    companion object {
        private const val TOKEN = "token"
        private const val FIELD = "field"
        private const val SORT_FIELD = "sortField"
        private const val SORT_TYPE = "sortType"
        private const val LIMIT = "limit"
        private const val PAGE = "page"
        private const val MOVIE_ID = "movieId"
        private const val QUERY = "query"

        private const val TOKEN_VALUE = "RAK4ET6-CNK4HSY-M72HXTB-AJVPAH4"
    }
}