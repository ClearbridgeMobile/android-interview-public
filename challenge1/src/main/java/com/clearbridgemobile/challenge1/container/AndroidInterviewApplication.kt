package com.clearbridgemobile.challenge1.container

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AndroidInterviewApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}