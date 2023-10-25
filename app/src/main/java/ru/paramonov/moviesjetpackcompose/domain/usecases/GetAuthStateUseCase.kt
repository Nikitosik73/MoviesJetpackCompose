package ru.paramonov.moviesjetpackcompose.domain.usecases

import kotlinx.coroutines.flow.StateFlow
import ru.paramonov.moviesjetpackcompose.domain.entity.AuthState
import ru.paramonov.moviesjetpackcompose.domain.repository.MovieRepository

class GetAuthStateUseCase(
    private val repository: MovieRepository
) {

    operator fun invoke(): StateFlow<AuthState> = repository.getAuthStateFlow()
}