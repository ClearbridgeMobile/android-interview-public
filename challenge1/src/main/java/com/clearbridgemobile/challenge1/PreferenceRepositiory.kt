package com.clearbridgemobile.challenge1

import android.content.Context

import android.content.SharedPreferences

/**
 * Preference repository to save app preferences
 */
class PreferenceRepository(context: Context)  {

  private val pref: SharedPreferences = context.getSharedPreferences(Constants.SETTINGS, 0)

  /**
   * update and retrieve welcome screen state
   */
  fun isWelcomeScreenShown(): Boolean {
    return pref.getBoolean(Constants.IS_WELCOME_SCREEN_SHOWN, false)
  }

  fun setIsWelcomeScreenShown(shown: Boolean) {
    pref.edit().putBoolean(Constants.IS_WELCOME_SCREEN_SHOWN, shown).apply()
  }
}