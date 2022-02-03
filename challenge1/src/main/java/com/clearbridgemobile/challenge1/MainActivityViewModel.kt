package com.clearbridgemobile.challenge1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

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

    fun onOkButtonClicked() {
        viewModelScope.launch(Dispatchers.Default) {
            _state.value = _state.value.copy(status = WelcomeScreenStatus.SHOWN)
        }
    }

}
