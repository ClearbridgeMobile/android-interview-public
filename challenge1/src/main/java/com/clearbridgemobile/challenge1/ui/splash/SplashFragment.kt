package com.clearbridgemobile.challenge1.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.clearbridgemobile.challenge1.R
import com.clearbridgemobile.challenge1.common.preferences.AppPreferences.Companion.WELCOME_SHOWN
import com.clearbridgemobile.challenge1.databinding.FragmentSplashBinding
import com.clearbridgemobile.challenge1.ui.common.fragment.BaseFragment

class SplashFragment : BaseFragment<FragmentSplashBinding, SplashViewModel>() {

    override var viewModelBindingVariable: Int = BR.viewModel
    override var layoutResId: Int = R.layout.fragment_splash
    var handler = Handler(Looper.getMainLooper())
    private val splashScreenTime = 3000L
    override fun provideViewModel(): SplashViewModel {
        return ViewModelProvider(this, viewModelFactory).get(SplashViewModel::class.java)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handler.postDelayed({
            if (prefs.getBoolean(WELCOME_SHOWN, false)) {
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
            } else {
                prefs.edit().putBoolean(WELCOME_SHOWN, true).apply()
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToWelcomeFragment())
            }
        },splashScreenTime)


    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }

}