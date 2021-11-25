package com.clearbridgemobile.challenge1.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.clearbridgemobile.challenge1.di.ViewModelKey
import com.clearbridgemobile.challenge1.ui.common.viewmodel.ViewModelFactory
import com.clearbridgemobile.challenge1.MainViewModel
import com.clearbridgemobile.challenge1.ui.home.HomeViewModel
import com.clearbridgemobile.challenge1.ui.splash.SplashViewModel
import com.clearbridgemobile.challenge1.ui.welcome.WelcomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainVM(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WelcomeViewModel::class)
    abstract fun bindWelcomeVM(viewModel: WelcomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeVM(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashVM(viewModel: SplashViewModel): ViewModel

}
