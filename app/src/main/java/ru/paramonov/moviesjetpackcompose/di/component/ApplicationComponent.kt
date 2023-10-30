package ru.paramonov.moviesjetpackcompose.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.paramonov.moviesjetpackcompose.di.annotation.ApplicationScope
import ru.paramonov.moviesjetpackcompose.di.module.DataModule
import ru.paramonov.moviesjetpackcompose.di.module.NetworkModule
import ru.paramonov.moviesjetpackcompose.di.module.ViewModelModule
import ru.paramonov.moviesjetpackcompose.presentation.viewmodelfactory.ViewModelFactory

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