package ru.mirea.moviesjetpackcompose.data.network.model.trailer

import com.google.gson.annotations.SerializedName

data class TrailerResponseDto(
    @SerializedName("docs") val contentTrailerResponse: VideosDto
)