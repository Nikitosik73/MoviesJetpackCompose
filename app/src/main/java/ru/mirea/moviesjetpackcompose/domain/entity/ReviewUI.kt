package ru.mirea.moviesjetpackcompose.domain.entity

data class ReviewUI(
    val id: Int,
    val title: String,
    val review: String,
    val author: String,
    val typeReview: String
)