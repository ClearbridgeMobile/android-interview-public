package com.clearbridgemobile.challenge1.vm

import android.content.Context
import androidx.lifecycle.ViewModel
import com.clearbridgemobile.challenge1.dataprovider.SharedPreferenceDataProvider
import com.clearbridgemobile.challenge1.util.Constants

class SplashViewModel : ViewModel() {

    fun isWelcomeVisited(context : Context): Boolean {
        val sharedPreferenceDataProvider = SharedPreferenceDataProvider(context)
        return sharedPreferenceDataProvider.getSharedPreference(Constants.WELCOME_SCRREN_VIEWED) != ""
    }
}