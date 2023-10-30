package ru.paramonov.moviesjetpackcompose.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.paramonov.moviesjetpackcompose.data.database.dao.FavoriteMoviesDao

abstract class AppDatabase : RoomDatabase() {

    abstract fun favoriteMoviesDao(): FavoriteMoviesDao

    companion object {

        private const val NAME_DB = "movie.db"
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            instance?.let { return it }

            synchronized(LOCK) {
                instance?.let { return it }
                val database = Room.databaseBuilder(
                    context = context,
                    klass = AppDatabase::class.java,
                    name = NAME_DB
                ).build()
                instance = database
                return database
            }
        }
    }
}