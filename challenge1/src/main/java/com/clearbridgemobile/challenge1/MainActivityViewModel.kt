package com.clearbridgemobile.challenge1

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

data class ApplicationViewState(
    val status: WelcomeScreenStatus
)

class MainActivityViewModel(
    initialState: ApplicationViewState = ApplicationViewState(
        status = WelcomeScreenStatus.NEVER_SHOWN
    )
) : ViewModel() {

    val state: StateFlow<ApplicationViewState>
        get() = _state
    private val _state = MutableStateFlow(initialState)

    private val sharedPreferences by inject(SharedPreferences::class.java)

    fun onOkButtonClicked() {
        viewModelScope.launch(Dispatchers.Default) {
            _state.value = _state.value.copy(status = WelcomeScreenStatus.SHOWN)

            sharedPreferences
                .edit()
                .putString(WELCOME_SCREEN_STATUS_KEY, _state.value.status.name)
                .apply()
        }
    }

    init {
        viewModelScope.launch(Dispatchers.Default) {
            sharedPreferences
                .getString(WELCOME_SCREEN_STATUS_KEY, initialState.status.name)
                .let { status ->
                    _state.value = _state.value.copy(status = WelcomeScreenStatus.valueOf(status!!))
                }
        }
    }

    companion object {
        const val WELCOME_SCREEN_STATUS_KEY = "WelcomeScreenStatus"
    }
}
