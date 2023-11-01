package ru.mirea.moviesjetpackcompose.domain.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import ru.mirea.moviesjetpackcompose.domain.entity.AuthState
import ru.mirea.moviesjetpackcompose.domain.entity.MovieUI
import ru.mirea.moviesjetpackcompose.domain.entity.ReviewUI
import ru.mirea.moviesjetpackcompose.domain.entity.TrailerUI

interface MovieRepository {

    fun getAuthStateFlow(): StateFlow<AuthState>

    suspend fun checkAuthState()

    fun getAllMovies(): StateFlow<List<MovieUI>>

    suspend fun loadNextMovies()

    fun getMoviesByName(query: String): Flow<List<MovieUI>>

    fun getReviews(movieId: Int): StateFlow<List<ReviewUI>>

    fun getTrailersByMovieId(movieId: Int): StateFlow<List<TrailerUI>>
}