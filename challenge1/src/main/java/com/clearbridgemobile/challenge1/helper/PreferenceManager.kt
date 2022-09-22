package com.clearbridgemobile.challenge1.helper

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {

    private var sharedPreferences: SharedPreferences =
        context.getSharedPreferences("AndroidInterview", 0)
    private var spEditor: SharedPreferences.Editor = sharedPreferences.edit()


    fun saveWelcomeScreenVisitedState(saveState: Boolean) {
        spEditor.putBoolean(AppConstants.WELCOME_SCREEN_STATE_SAVED, true)
        spEditor.commit()
    }

    fun getWelcomeScreenVisitedState(): Boolean {
        return sharedPreferences.getBoolean(AppConstants.WELCOME_SCREEN_STATE_SAVED, false)
    }
}