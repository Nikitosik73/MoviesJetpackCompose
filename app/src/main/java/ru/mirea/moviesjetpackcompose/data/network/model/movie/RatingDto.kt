package ru.mirea.moviesjetpackcompose.data.network.model.movie

import com.google.gson.annotations.SerializedName

data class RatingDto(
    @SerializedName("imdb") val ratingMovie: Double
)