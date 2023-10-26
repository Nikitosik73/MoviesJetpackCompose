package ru.paramonov.moviesjetpackcompose.data.network.model.trailer

import com.google.gson.annotations.SerializedName

data class TrailerListDto(
    @SerializedName("trailers") val listTrailersUrl: List<TrailerDto>
)