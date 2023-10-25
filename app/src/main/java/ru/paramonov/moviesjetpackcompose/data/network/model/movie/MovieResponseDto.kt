package ru.paramonov.moviesjetpackcompose.data.network.model.movie

import com.google.gson.annotations.SerializedName

data class MovieResponseDto(
    @SerializedName("docs") val contentMovieList: List<MovieDto>
)