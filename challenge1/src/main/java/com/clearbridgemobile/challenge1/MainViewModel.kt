package com.clearbridgemobile.challenge1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> get() =  _isLoading

    init {
        viewModelScope.launch {
            //Since the requirement was to keep splash screen for 3 S active we have used delay
            // Here we could have also done any other long running tasks like hitting API
            // to initialise data
            delay(3000)
            _isLoading.value = false
        }
    }


}