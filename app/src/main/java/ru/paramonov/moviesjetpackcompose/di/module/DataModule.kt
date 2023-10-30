package ru.paramonov.moviesjetpackcompose.di.module

import android.content.Context
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import dagger.Binds
import dagger.Module
import dagger.Provides
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
    }
}