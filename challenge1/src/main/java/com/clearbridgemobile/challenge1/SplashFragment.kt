package com.clearbridgemobile.challenge1

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class SplashFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    @Suppress("DEPRECATION")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed({
            if(isWelcomeSaved()){
                fragmentManager?.run{
                    beginTransaction()
                        .replace(R.id.frame_container, HomeFragment())
                        .commit()
                }
            }else{
                fragmentManager?.run{
                    beginTransaction()
                        .replace(R.id.frame_container, WelcomeFragment())
                        .commit()
                }
            }
        }, DELAY_TIMER)
    }

    private fun isWelcomeSaved(): Boolean {
        val sharedPreferences: SharedPreferences = requireContext().getSharedPreferences(
            resources.getString(R.string.app_name),
            Context.MODE_PRIVATE
        )
        return sharedPreferences.getBoolean(WELCOME_PREFERENCES_KEY, false)
    }

    companion object {
        private const val WELCOME_PREFERENCES_KEY = "WELCOME_PREFERENCES_KEY"
        private const val DELAY_TIMER = 3000L
    }
}