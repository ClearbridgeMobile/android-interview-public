package com.clearbridgemobile.challenge1.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.clearbridgemobile.challenge1.AppConstant
import com.clearbridgemobile.challenge1.databinding.ActivitySplashBinding
import com.clearbridgemobile.challenge1.model.SplashModel
import com.clearbridgemobile.challenge1.util.PreferenceHelper
import com.clearbridgemobile.challenge1.util.PreferenceHelper.welcomePref
import com.clearbridgemobile.challenge1.viewmodel.SplashViewModel

class SplashActivity : AppCompatActivity() {

    private lateinit var splashViewModel: SplashViewModel
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViewModel()
        observeSplashLiveData()
    }

    private fun initViewModel() {
        splashViewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
    }

    private fun observeSplashLiveData() {
        splashViewModel.initSplashScreen()
        val observer = Observer<SplashModel> {
            if (isWelcomeOpen()) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        splashViewModel.liveData.observe(this, observer)
    }

    private fun isWelcomeOpen(): Boolean {
        return PreferenceHelper.preference(this, AppConstant.WELCOME_PREF).welcomePref
    }

}
