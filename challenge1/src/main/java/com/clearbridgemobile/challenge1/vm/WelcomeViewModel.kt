package com.clearbridgemobile.challenge1.vm

import android.content.Context
import androidx.lifecycle.ViewModel
import com.clearbridgemobile.challenge1.dataprovider.SharedPreferenceDataProvider
import com.clearbridgemobile.challenge1.util.Constants

class WelcomeViewModel : ViewModel() {

    fun viewed(context: Context) {
        val sharedPreferenceDataProvider = SharedPreferenceDataProvider(context)
        sharedPreferenceDataProvider.setSharedPreference(Constants.WELCOME_SCRREN_VIEWED, "Y")
    }
}