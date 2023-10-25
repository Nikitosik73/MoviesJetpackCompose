package ru.paramonov.moviesjetpackcompose.domain.usecases

import ru.paramonov.moviesjetpackcompose.domain.repository.MovieRepository

class CheckAuthStateUseCase(
    private val repository: MovieRepository
) {

    suspend operator fun invoke() = repository.checkAuthState()
}