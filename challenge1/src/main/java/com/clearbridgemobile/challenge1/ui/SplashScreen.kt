package com.clearbridgemobile.challenge1.ui

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.clearbridgemobile.challenge1.R
import com.clearbridgemobile.challenge1.util.Constants
import com.clearbridgemobile.challenge1.vm.SplashViewModel

class SplashScreen : AppCompatActivity() {

    lateinit var counter: TextView
    lateinit var mViewModel: SplashViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        mViewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        counter = findViewById(R.id.counter)
        startCounter(3)
    }

    private fun startCounter(countDown: Int) {
        var number = countDown
        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                counter.text = number.toString()
                number--
            }

            override fun onFinish() {
                navigate()
                finish()
            }
        }.start()
    }

    private fun navigate() {
        val intent = when (mViewModel.isWelcomeVisited(this)) {
            true -> com.clearbridgemobile.challenge1.navigator.navigate(Constants.Companion.Screens.HOME_SCREEN, this )
            else -> com.clearbridgemobile.challenge1.navigator.navigate(Constants.Companion.Screens.WELCOME_SCREEN, this )
        }
    }
}