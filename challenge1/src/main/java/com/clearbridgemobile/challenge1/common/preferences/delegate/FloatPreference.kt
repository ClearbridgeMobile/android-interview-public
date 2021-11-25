package com.addenergie.reseauver.common.preferences.delegate
import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class FloatPreference(
    private val sharedPreferences: SharedPreferences,
    private val key: String,
    private val defaultValue: Float = 0.0f
) : ReadWriteProperty<Any, Float> {

    override fun getValue(thisRef: Any, property: KProperty<*>): Float =
        sharedPreferences.getFloat(key, defaultValue)

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Float) =
        sharedPreferences.edit()
            .putFloat(key, value)
            .apply()
}