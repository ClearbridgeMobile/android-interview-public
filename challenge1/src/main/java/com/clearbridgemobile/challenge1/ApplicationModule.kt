package com.clearbridgemobile.challenge1

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val applicationModule = module {
    factory { androidContext().getSharedPreferences("Test", Context.MODE_PRIVATE) }
}