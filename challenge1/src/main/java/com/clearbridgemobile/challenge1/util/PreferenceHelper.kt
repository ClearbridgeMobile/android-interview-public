package com.clearbridgemobile.challenge1.util

import android.content.Context
import android.content.SharedPreferences
import com.clearbridgemobile.challenge1.AppConstant

object PreferenceHelper {
    fun preference(context: Context, name: String): SharedPreferences =
        context.getSharedPreferences(name, Context.MODE_PRIVATE)

    private inline fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) {
        val editMe = edit()
        operation(editMe)
        editMe.apply()
    }


    var SharedPreferences.welcomePref
        get() = getBoolean(AppConstant.WELCOME_PREF, false)
        set(value) {
            editMe {
                it.putBoolean(AppConstant.WELCOME_PREF, value)
            }
        }
}