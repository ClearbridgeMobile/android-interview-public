package com.clearbridgemobile.challenge1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.clearbridgemobile.challenge1.R
import com.clearbridgemobile.challenge1.databinding.ActivityWelcomeBinding
import com.clearbridgemobile.challenge1.dataprovider.SharedPreferenceDataProvider
import com.clearbridgemobile.challenge1.util.Constants
import com.clearbridgemobile.challenge1.vm.WelcomeViewModel

class WelcomeActivity : AppCompatActivity() {
    private var binding: ActivityWelcomeBinding? = null
    private val viewModel = WelcomeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_welcome
        ) as ActivityWelcomeBinding?

        binding?.let {
            it.lifecycleOwner = this
        }
    }

    fun okClicked(v: View){
        viewModel.viewed(this)
        navigate()
    }

    private fun navigate() {
        com.clearbridgemobile.challenge1.navigator.navigate(Constants.Companion.Screens.HOME_SCREEN, this )

    }
}