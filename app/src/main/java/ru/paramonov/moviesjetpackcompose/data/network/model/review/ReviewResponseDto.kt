package ru.paramonov.moviesjetpackcompose.data.network.model.review

import com.google.gson.annotations.SerializedName

data class ReviewResponseDto(
    @SerializedName("docs") val contentReviewResponse: List<ReviewDto>
)