package com.clearbridgemobile.challenge1.common.app

import android.app.Application
import com.clearbridgemobile.challenge1.di.component.ApplicationComponent
import com.clearbridgemobile.challenge1.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class ThisApplication : Application(), HasAndroidInjector {

    private lateinit var component: ApplicationComponent

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>


    init {
        instance = this
    }

    companion object {
        private var instance: ThisApplication? = null

        fun applicationComponent(): ApplicationComponent? = instance?.component
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.builder()
            .application(this)
            .build()
        component.inject(this)


    }



    override fun androidInjector(): AndroidInjector<Any> = androidInjector

}