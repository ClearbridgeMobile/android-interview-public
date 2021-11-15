package com.clearbridgemobile.challenge1

import android.content.Context

class SharedPreferences(context: Context) {

    companion object {
        const val PREFS_NAME = "com.clearbridgemobile.challenge1.preferenceFileKey"
        const val SKIP_WELCOME = "skipWelcome"
    }

    private val ctx = context

    private val sharedPrefs = ctx.getSharedPreferences(
        PREFS_NAME,
        Context.MODE_PRIVATE
    )!!

    var skipWelcome: Boolean
        get() {
            val defaultValue = false
            return sharedPrefs.getBoolean(SKIP_WELCOME, defaultValue)
        }
        set(value) {
            with(sharedPrefs.edit()) {
                putBoolean(SKIP_WELCOME, value)
                apply()
            }
        }
}