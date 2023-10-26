package ru.paramonov.moviesjetpackcompose.data.network.model.trailer

import com.google.gson.annotations.SerializedName

data class VideosDto(
    @SerializedName("videos") val video: TrailerListDto
)