package ru.mirea.moviesjetpackcompose.data.mapper

import ru.mirea.moviesjetpackcompose.data.database.model.MovieDbModel
import ru.mirea.moviesjetpackcompose.domain.entity.MovieUI
import javax.inject.Inject

class FavoriteMovieMapper @Inject constructor() {

    fun mapDbModelToEntity(db: MovieDbModel) = MovieUI(
        id = db.id,
        name = db.name,
        description = db.description,
        year = db.year,
        poster = db.poster,
        rating = db.rating
    )

    fun mapEntityToDbModel(entity: MovieUI) = MovieDbModel(
        id = entity.id,
        name = entity.name,
        description = entity.description,
        year = entity.year,
        poster = entity.poster,
        rating = entity.rating
    )
}