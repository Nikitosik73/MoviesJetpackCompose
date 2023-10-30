package ru.paramonov.moviesjetpackcompose.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.paramonov.moviesjetpackcompose.data.database.model.MovieDbModel

@Dao
interface FavoriteMoviesDao {

    @Query("select * from movies")
    fun getAllMoviesFromDb(): Flow<List<MovieDbModel>>

    @Insert
    suspend fun insertMovieFromDb(movie: MovieDbModel)

    @Query("delete from movies where id = :movieId")
    suspend fun removeMovieToDb(movieId: Int)
}