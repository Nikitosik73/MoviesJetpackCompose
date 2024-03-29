package ru.mirea.moviesjetpackcompose.presentation.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import ru.mirea.moviesjetpackcompose.domain.entity.AuthState
import ru.mirea.moviesjetpackcompose.domain.usecases.CheckAuthStateUseCase
import ru.mirea.moviesjetpackcompose.domain.usecases.GetAuthStateUseCase
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val getAuthStateUseCase: GetAuthStateUseCase,
    private val checkAuthStateUseCase: CheckAuthStateUseCase
): ViewModel() {

    val viewState: Flow<AuthState> = getAuthStateUseCase()

    fun performAuthResult() = viewModelScope.launch { checkAuthStateUseCase() }
}