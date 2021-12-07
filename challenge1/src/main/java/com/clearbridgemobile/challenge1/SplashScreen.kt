package com.clearbridgemobile.challenge1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper


import androidx.appcompat.app.AppCompatActivity

class SplashScreen :AppCompatActivity() {


    // This is the loading time of the splash screen
    private val SPLASH_TIME_OUT: Long = 3000 // 1 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000)
    }
//ANOTHER METHOD
//        setContentView(R.layout.activity_splash)
//        Handler().postDelayed({
//            // This method will be executed once the timer is over
//                // Start your app main activity
//
//                startActivity(Intent(this, MainActivity::class.java))
//
//                // close this activity
//                finish()
//            }, SPLASH_TIME_OUT)
//        }
}