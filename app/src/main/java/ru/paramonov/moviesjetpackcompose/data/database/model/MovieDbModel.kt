package ru.paramonov.moviesjetpackcompose.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val description: String,
    val year: Int,
    val poster: String,
    val rating: Double
)