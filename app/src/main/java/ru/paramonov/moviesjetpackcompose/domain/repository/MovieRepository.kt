package ru.paramonov.moviesjetpackcompose.domain.repository

import kotlinx.coroutines.flow.StateFlow
import ru.paramonov.moviesjetpackcompose.domain.entity.AuthState

interface MovieRepository {

    fun getAuthStateFlow(): StateFlow<AuthState>

    suspend fun checkAuthState()
}