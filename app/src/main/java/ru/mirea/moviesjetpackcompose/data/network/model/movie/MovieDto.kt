package ru.mirea.moviesjetpackcompose.data.network.model.movie

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("year") val year: Int,
    @SerializedName("poster") val poster: PosterDto,
    @SerializedName("rating") val rating: RatingDto
)