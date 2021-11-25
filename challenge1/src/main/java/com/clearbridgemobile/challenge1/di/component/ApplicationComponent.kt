package com.clearbridgemobile.challenge1.di.component

import android.app.Application
import com.clearbridgemobile.challenge1.common.app.ThisApplication
import com.clearbridgemobile.challenge1.di.module.ActivityBuilderModule
import com.clearbridgemobile.challenge1.di.module.AppModule
import com.clearbridgemobile.challenge1.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ViewModelModule::class,
        ActivityBuilderModule::class
    ]
)
interface ApplicationComponent {

    fun inject(application: ThisApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}