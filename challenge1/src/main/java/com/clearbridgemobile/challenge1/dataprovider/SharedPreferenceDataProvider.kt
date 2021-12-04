package com.clearbridgemobile.challenge1.dataprovider

import android.content.Context
import com.clearbridgemobile.challenge1.repository.SharedPreferenceRepository

class SharedPreferenceDataProvider constructor(private val context : Context){

    private val sharedPreferenceRepository: SharedPreferenceRepository = SharedPreferenceRepository()

    fun setSharedPreference(key : String, value : String) =
        sharedPreferenceRepository.set(key, value, context)

    fun getSharedPreference(key : String) = sharedPreferenceRepository.get(key, context)

}