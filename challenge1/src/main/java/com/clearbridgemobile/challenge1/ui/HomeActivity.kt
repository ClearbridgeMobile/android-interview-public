package com.clearbridgemobile.challenge1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.clearbridgemobile.challenge1.R
import com.clearbridgemobile.challenge1.databinding.ActivityHomeBinding
import com.clearbridgemobile.challenge1.databinding.ActivityWelcomeBinding
import com.clearbridgemobile.challenge1.vm.HomeViewModel

class HomeActivity : AppCompatActivity() {
    private var binding:  ActivityHomeBinding? = null
    private val viewModel = HomeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_home
        ) as ActivityHomeBinding?

        binding?.let {
            it.lifecycleOwner = this
            it.tvTime.text =  getString(R.string.home_time, viewModel.getTime())
        }


    }
}