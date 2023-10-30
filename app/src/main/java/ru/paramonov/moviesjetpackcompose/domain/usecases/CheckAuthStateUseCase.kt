package ru.paramonov.moviesjetpackcompose.domain.usecases

import ru.paramonov.moviesjetpackcompose.domain.repository.MovieRepository
import javax.inject.Inject

class CheckAuthStateUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    suspend operator fun invoke() = repository.checkAuthState()
}