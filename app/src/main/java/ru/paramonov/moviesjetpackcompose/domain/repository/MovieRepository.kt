package ru.paramonov.moviesjetpackcompose.domain.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import ru.paramonov.moviesjetpackcompose.domain.entity.AuthState
import ru.paramonov.moviesjetpackcompose.domain.entity.MovieUI
import ru.paramonov.moviesjetpackcompose.domain.entity.ReviewUI
import ru.paramonov.moviesjetpackcompose.domain.entity.TrailerUI

interface MovieRepository {

    fun getAuthStateFlow(): StateFlow<AuthState>

    suspend fun checkAuthState()

    fun getAllMovies(): StateFlow<List<MovieUI>>

    suspend fun loadNextMovies()

    fun getMoviesByName(query: String): Flow<List<MovieUI>>

    fun getReviews(movieId: Int): StateFlow<List<ReviewUI>>

    fun getTrailersByMovieId(movieId: Int): StateFlow<List<TrailerUI>>
}