package com.clearbridgemobile.challenge1.common.preferences

import android.content.SharedPreferences
import com.addenergie.reseauver.common.preferences.delegate.BooleanPreference
import com.addenergie.reseauver.common.preferences.delegate.IntPreference
import kotlin.properties.ReadWriteProperty

fun SharedPreferences.int(key: String, defaultValue: Int = 0): ReadWriteProperty<Any, Int> =
    IntPreference(this, key, defaultValue)

fun SharedPreferences.boolean(
    key: String,
    defaultValue: Boolean = false
): ReadWriteProperty<Any, Boolean> =
    BooleanPreference(this, key, defaultValue)
