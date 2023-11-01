package ru.mirea.moviesjetpackcompose.data.network.model.review

import com.google.gson.annotations.SerializedName

data class ReviewDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("review") val review: String,
    @SerializedName("author") val author: String,
    @SerializedName("type") val typeReview: String
)