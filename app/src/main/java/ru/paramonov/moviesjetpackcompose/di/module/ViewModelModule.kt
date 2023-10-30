package ru.paramonov.moviesjetpackcompose.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.paramonov.moviesjetpackcompose.di.annotation.ViewModelKey
import ru.paramonov.moviesjetpackcompose.presentation.screens.login.LoginViewModel

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(value = LoginViewModel::class)
    fun bindLoginViewModel(
        impl: LoginViewModel
    ): ViewModel
}