package com.clearbridgemobile.challenge1

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Splash UI state data
 */
data class SplashUiState(val nextNavigateRoute: String)

/**
 * Splash UI view Model, runs 3 seconds timer and decides what's the next screen.
 */
class SplashViewModel(val preferenceRepository: PreferenceRepository): ViewModel() {

  private val _uiState = MutableStateFlow(SplashUiState(nextNavigateRoute = ""))
  val uiState: StateFlow<SplashUiState> = _uiState.asStateFlow()

  fun startTimer() {
    viewModelScope.launch {
      object: CountDownTimer(3000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
          //NO-OP
        }

        override fun onFinish() {
          _uiState.update {
            it.copy(
              nextNavigateRoute = if (preferenceRepository.isWelcomeScreenShown()) {
                Constants.HOME_SCREEN
              } else {
                preferenceRepository.setIsWelcomeScreenShown(true)
                Constants.WELCOME_SCREEN
              }
            )
          }
        }
      }.start()
    }
  }

  /**
   * Factory for SplashViewModel
   */
  companion object {
    fun provideFactory(preferenceRepository: PreferenceRepository): ViewModelProvider.Factory = object: ViewModelProvider.Factory {
      @Suppress("UNCHECKED_CAST")
      override fun <T: ViewModel> create(modelClass: Class<T>): T {
        return SplashViewModel(preferenceRepository) as T
      }
    }
  }
}
