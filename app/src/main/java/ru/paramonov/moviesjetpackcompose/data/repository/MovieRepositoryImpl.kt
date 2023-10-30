package ru.paramonov.moviesjetpackcompose.data.repository

import com.vk.api.sdk.VKPreferencesKeyValueStorage
import com.vk.api.sdk.auth.VKAccessToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import ru.paramonov.moviesjetpackcompose.data.mapper.MovieMapper
import ru.paramonov.moviesjetpackcompose.data.network.api.ApiService
import ru.paramonov.moviesjetpackcompose.domain.entity.AuthState
import ru.paramonov.moviesjetpackcompose.domain.entity.MovieUI
import ru.paramonov.moviesjetpackcompose.domain.entity.ReviewUI
import ru.paramonov.moviesjetpackcompose.domain.entity.TrailerUI
import ru.paramonov.moviesjetpackcompose.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: MovieMapper,
    private val storage: VKPreferencesKeyValueStorage
) : MovieRepository {

    private val token
        get() = VKAccessToken.restore(storage)

    private val scope = CoroutineScope(context = Dispatchers.Default)

    private val checkAuthStateEvents = MutableSharedFlow<Unit>(replay = 1)
    private val authState: StateFlow<AuthState> = flow {
        checkAuthStateEvents.emit(Unit)
        checkAuthStateEvents.collect {
            val currentToken = token
            val loggedIn = currentToken != null && currentToken.isValid
            val authState = if (loggedIn) AuthState.Authorized else AuthState.NotAuthorized
            emit(authState)
        }
    }.stateIn(
        scope = scope,
        started = SharingStarted.Lazily,
        initialValue = AuthState.Initial
    )

    override fun getAuthStateFlow(): StateFlow<AuthState> = authState

    override suspend fun checkAuthState() {
        checkAuthStateEvents.emit(Unit)
    }

    private val _movies = mutableListOf<MovieUI>()
    private val movies: List<MovieUI>
        get() = _movies

    private var page = 1

    private val loadedNextMoviesEvents = MutableSharedFlow<Unit>(replay = 1)
    private val loadAllMovies = flow {
        loadedNextMoviesEvents.emit(Unit)
        loadedNextMoviesEvents.collect {
            val response = apiService.getAllMoviesResponse(page = page)
            val moviesUi = mapper.mapMovieDtoToMovieUi(response = response)

            if (moviesUi.isNotEmpty()) {
                _movies.addAll(moviesUi)
                page++
            }

            emit(movies)
        }
    }

    override fun getAllMovies(): StateFlow<List<MovieUI>> = loadAllMovies
        .stateIn(
            scope = scope,
            started = SharingStarted.Lazily,
            initialValue = listOf()
        )

    override suspend fun loadNextMovies() {
        loadedNextMoviesEvents.emit(Unit)
    }

    override fun getMoviesByName(query: String): Flow<List<MovieUI>> = flow {
        val response = apiService.getMoviesByName(query = query)
        val movieUI = mapper.mapMovieDtoToMovieUi(response = response)
        emit(movieUI)
    }

    override fun getReviews(movieId: Int): StateFlow<List<ReviewUI>> = flow {
        val response = apiService.getAllReviewsResponse(movieId = movieId)
        val reviewsUi = mapper.mapReviewDtoToReviewUi(response = response)
        emit(reviewsUi)
    }.stateIn(
        scope = scope,
        started = SharingStarted.Lazily,
        initialValue = listOf()
    )

    override fun getTrailersByMovieId(movieId: Int): StateFlow<List<TrailerUI>> = flow {
        val response = apiService.getTrailersByMovieId(id = movieId)
        val trailersUi = mapper.mapTrailersDtoToTrailersUi(response = response)
        emit(trailersUi)
    }.stateIn(
        scope = scope,
        started = SharingStarted.Lazily,
        initialValue = listOf()
    )
}