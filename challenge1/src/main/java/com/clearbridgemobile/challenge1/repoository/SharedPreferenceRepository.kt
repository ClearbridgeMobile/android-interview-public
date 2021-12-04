package com.clearbridgemobile.challenge1.repository

import android.content.Context
import android.content.SharedPreferences
import com.clearbridgemobile.challenge1.util.Constants

class SharedPreferenceRepository {

    fun set(key : String, value: String, context: Context) {
        val editor: SharedPreferences.Editor =
            context.getSharedPreferences(Constants.CHALLENGE, Context.MODE_PRIVATE)
                .edit()
        editor.putString(key, value)
        editor.commit()
    }

    fun get(key : String,  context: Context) : String {
        val prefs: SharedPreferences =
            context.getSharedPreferences(Constants.CHALLENGE, Context.MODE_PRIVATE)
        return prefs.getString(key, "") ?: ""
    }
}