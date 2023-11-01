package ru.mirea.moviesjetpackcompose.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.mirea.moviesjetpackcompose.di.annotation.ApplicationScope
import ru.mirea.moviesjetpackcompose.di.module.DataModule
import ru.mirea.moviesjetpackcompose.di.module.NetworkModule
import ru.mirea.moviesjetpackcompose.di.module.ViewModelModule
import ru.mirea.moviesjetpackcompose.presentation.viewmodelfactory.ViewModelFactory

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        NetworkModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun getViewModelFactory(): ViewModelFactory

    @Component.Factory
    interface ApplicationFactory {

        fun create(
            @BindsInstance context: Context
        ): ApplicationComponent
    }
}