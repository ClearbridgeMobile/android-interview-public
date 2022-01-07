package com.clearbridgemobile.challenge1.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.clearbridgemobile.challenge1.AppConstant
import com.clearbridgemobile.challenge1.databinding.ActivityWelcomeBinding
import com.clearbridgemobile.challenge1.util.PreferenceHelper
import com.clearbridgemobile.challenge1.util.PreferenceHelper.welcomePref

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        onClickOK()
        PreferenceHelper.preference(this, AppConstant.WELCOME_PREF).welcomePref = true
    }

    private fun onClickOK() {
        binding.button.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
