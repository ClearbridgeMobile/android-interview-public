package com.clearbridgemobile.challenge1.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.clearbridgemobile.challenge1.R
import com.clearbridgemobile.challenge1.databinding.ActivityHomeBinding
import java.util.*

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        (resources.getString(R.string.time) + " " + getCurrentTime()).also {
            binding.txtTime.text = it
        }
    }

    private fun getCurrentTime(): Date = Calendar.getInstance().time
}
