package ru.mirea.moviesjetpackcompose.domain.usecases

import kotlinx.coroutines.flow.StateFlow
import ru.mirea.moviesjetpackcompose.domain.entity.AuthState
import ru.mirea.moviesjetpackcompose.domain.repository.MovieRepository
import javax.inject.Inject

class GetAuthStateUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    operator fun invoke(): StateFlow<AuthState> = repository.getAuthStateFlow()
}