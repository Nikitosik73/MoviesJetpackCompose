package ru.mirea.moviesjetpackcompose.presentation.screens.movies

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import ru.mirea.moviesjetpackcompose.domain.usecases.GetAllMoviesUseCase
import ru.mirea.moviesjetpackcompose.domain.usecases.LoadNextMoviesUseCase
import ru.mirea.moviesjetpackcompose.presentation.extensions.mergeWith
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val getAllMoviesUseCase: GetAllMoviesUseCase,
    private val loadNextMoviesUseCase: LoadNextMoviesUseCase
): ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        Log.d("MovieViewModel", "Exception caught by handler")
    }

    private val allMovies = getAllMoviesUseCase()

    private val nextDataLoadingEvents = MutableSharedFlow<Unit>()
    private val nextDataLoadingMovies = flow {
        nextDataLoadingEvents.collect {
            emit(
                MovieViewState.ContentMovies(
                    data = allMovies.value,
                    isLoading = true
                )
            )
        }
    }

    val viewStateMovies: Flow<MovieViewState> = allMovies
        .filter { it.isNotEmpty() }
        .map { MovieViewState.ContentMovies(data = it) as MovieViewState }
        .onStart { emit(MovieViewState.Loading) }
        .mergeWith(another = nextDataLoadingMovies)

    fun loadNextDataMovies() = viewModelScope.launch(exceptionHandler) {
        nextDataLoadingEvents.emit(Unit)
        loadNextMoviesUseCase()
    }
}