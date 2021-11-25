package com.clearbridgemobile.challenge1.di.module


import com.clearbridgemobile.challenge1.ui.home.HomeFragment
import com.clearbridgemobile.challenge1.ui.splash.SplashFragment
import com.clearbridgemobile.challenge1.ui.welcome.WelcomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentProvider {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributeWelcomeFragment(): WelcomeFragment


    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashFragment

}