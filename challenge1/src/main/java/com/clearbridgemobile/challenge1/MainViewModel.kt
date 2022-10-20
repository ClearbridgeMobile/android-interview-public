package com.clearbridgemobile.challenge1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class MainViewModel: ViewModel() {

    //Variable to keep track of spalsh screen loading
    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> get() =  _isLoading

    // to keep track of button click even on Welcome screen
    private val _isOKClickedMutableLiveData = MutableLiveData<Boolean>()
    val isOkClickedLiveData: LiveData<Boolean> get() = _isOKClickedMutableLiveData

    init {
        viewModelScope.launch {
            //Since the requirement was to keep splash screen for 3 S active we have used delay
            // Here we could have also done any other long running tasks like hitting API
            // to initialise data
            delay(3000)
            _isLoading.value = false
        }
    }

    // Will be called once Ok button is clicked from Welcome screen
    fun setIsOkClickedItem(isOkCLicked: Boolean) {
        _isOKClickedMutableLiveData.value = isOkCLicked
    }

    fun getCurrentTime(): Date = Calendar.getInstance().time

}