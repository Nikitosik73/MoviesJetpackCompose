package ru.paramonov.moviesjetpackcompose.data.network.model.trailer

import com.google.gson.annotations.SerializedName

data class TrailerDto(
    @SerializedName("url") val trailerUrl: String
)