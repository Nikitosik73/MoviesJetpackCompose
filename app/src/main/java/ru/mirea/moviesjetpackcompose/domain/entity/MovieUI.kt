package ru.mirea.moviesjetpackcompose.domain.entity

data class MovieUI(
    val id: Int,
    val name: String,
    val description: String,
    val year: Int,
    val poster: String,
    val rating: Double
)
