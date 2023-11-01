package ru.mirea.moviesjetpackcompose.di.module

import android.content.Context
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.mirea.moviesjetpackcompose.data.database.AppDatabase
import ru.mirea.moviesjetpackcompose.data.database.dao.FavoriteMoviesDao
import ru.mirea.moviesjetpackcompose.data.repository.MovieRepositoryImpl
import ru.mirea.moviesjetpackcompose.di.annotation.ApplicationScope
import ru.mirea.moviesjetpackcompose.domain.repository.MovieRepository

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindMovieRepository(
        impl: MovieRepositoryImpl
    ): MovieRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideVKStorage(
            context: Context
        ): VKPreferencesKeyValueStorage =
            VKPreferencesKeyValueStorage(context = context)

        @Provides
        @ApplicationScope
        fun provideAppDatabase(
            context: Context
        ): AppDatabase = AppDatabase.getInstance(context = context)

        @Provides
        @ApplicationScope
        fun provideApiService(
            database: AppDatabase
        ): FavoriteMoviesDao = database.favoriteMoviesDao()
    }
}