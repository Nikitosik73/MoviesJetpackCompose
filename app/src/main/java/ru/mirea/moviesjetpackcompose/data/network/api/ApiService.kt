package ru.mirea.moviesjetpackcompose.data.network.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.mirea.moviesjetpackcompose.data.network.model.movie.MovieResponseDto
import ru.mirea.moviesjetpackcompose.data.network.model.review.ReviewResponseDto
import ru.mirea.moviesjetpackcompose.data.network.model.trailer.TrailerResponseDto

interface ApiService {

    @GET("v1.3/movie")
    suspend fun getAllMoviesResponse(
        @Query(TOKEN) token: String = TOKEN_VALUE,
        @Query(FIELD) field: String = "rating.kp",
        @Query(SEARCH) search: String = "4-8",
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

    @GET("v1.3/movie")
    suspend fun getTrailersByMovieId(
        @Query(TOKEN) token: String = TOKEN_VALUE,
        @Query(SELECT_FIELDS) selectFields: String = "videos.trailers.url",
        @Query(ID) id: Int
    ): TrailerResponseDto

    companion object {
        private const val TOKEN = "token"
        private const val FIELD = "field"
        private const val SORT_FIELD = "sortField"
        private const val SORT_TYPE = "sortType"
        private const val LIMIT = "limit"
        private const val PAGE = "page"
        private const val MOVIE_ID = "movieId"
        private const val QUERY = "query"
        private const val SEARCH = "search"
        private const val SELECT_FIELDS = "selectFields"
        private const val ID = "id"

        private const val TOKEN_VALUE = "QPDWPTP-7N8M9QP-K2WGE2M-7YFE8SH"
    }
}