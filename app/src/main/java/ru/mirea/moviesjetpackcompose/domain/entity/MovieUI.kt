package ru.mirea.moviesjetpackcompose.domain.entity

data class MovieUI(
    val id: Int = 1,
    val name: String = "Мстители",
    val description: String = "Просто пиздатый фильм",
    val year: Int = 2012,
    val poster: String = "fasjfklajfa",
    val rating: Double = 10.0
)
