package ru.paramonov.moviesjetpackcompose.di.module

import android.content.Context
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.paramonov.moviesjetpackcompose.data.database.AppDatabase
import ru.paramonov.moviesjetpackcompose.data.database.dao.FavoriteMoviesDao
import ru.paramonov.moviesjetpackcompose.data.network.api.ApiService
import ru.paramonov.moviesjetpackcompose.data.repository.MovieRepositoryImpl
import ru.paramonov.moviesjetpackcompose.di.annotation.ApplicationScope
import ru.paramonov.moviesjetpackcompose.domain.repository.MovieRepository

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