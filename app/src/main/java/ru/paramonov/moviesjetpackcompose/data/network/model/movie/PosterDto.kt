package ru.paramonov.moviesjetpackcompose.data.network.model.movie

import com.google.gson.annotations.SerializedName

data class PosterDto(
    @SerializedName("url") val posterUrl: String
)