package com.clearbridgemobile.challenge1.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.clearbridgemobile.challenge1.helper.PreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

@HiltViewModel
class BaseViewModel @Inject constructor(
    private val preferenceManager: PreferenceManager
) : ViewModel() {

    private val _time = MutableLiveData<Date?>()
    val time: LiveData<Date?> = _time


    fun saveWelcomeScreenState() {
        preferenceManager.saveWelcomeScreenVisitedState(true)
    }

    fun getWelcomeScreenState(): Boolean {
        return preferenceManager.getWelcomeScreenVisitedState()
    }

    fun getCurrentTime() {
        val currentTime : Date = Calendar.getInstance().time
        _time.value = currentTime
    }
}