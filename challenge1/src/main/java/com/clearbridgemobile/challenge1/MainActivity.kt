package com.clearbridgemobile.challenge1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.clearbridgemobile.challenge1.databinding.ActivityMainBinding

// If App is Launched Second time set var to true
private const val SUCCESSIVE_LAUNCH = "SUCCESSIVE_LAUNCH"
private const val PREF_NAME = "MY_SHARED_PREF"

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        // Initialise with Splash Screen and observing the value from viewModel
        // WIll be showing splashscreen until isLoading is returned false after 3 Seconds
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isLoading.value == true
            }
        }
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // For First Time Launch after installation SUCCESSIVE_LAUNCH is set to false
        val sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE)
        val isSuccessiveLaunch = sharedPreferences.getBoolean(SUCCESSIVE_LAUNCH, false)
        if (isSuccessiveLaunch) {
            setFragment(HomeFragment())
        } else {
            sharedPreferences.edit().apply {
                putBoolean(SUCCESSIVE_LAUNCH, true)
                apply()
                setFragment(WelcomeFragment())
            }
        }

        // Here liveData will contain value true if user has clicked on OK Button from Welcome Fragment
        viewModel.isOkClickedLiveData.observe(this) {
            if (it == true) {
                setFragment(HomeFragment())
            }
        }
    }

    // Function to set Fragment
    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment)
            commit()
        }
    }
}
