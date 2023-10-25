package ru.paramonov.moviesjetpackcompose.domain.entity

sealed class AuthState {

    object Initial : AuthState()

    object Authorized : AuthState()

    object NotAuthorized : AuthState()
}