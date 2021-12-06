package com.clearbridgemobile.challenge1

import android.os.Bundle
import android.widget.TextView
import com.clearbridgemobile.challenge1.databinding.ActivityHomeBinding
import java.util.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class HomeActivity : AppCompatActivity() {
    private var backPressedTime:Long = 0
    lateinit var backToast:Toast
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        binding.txtViewTime.text = "${getString(R.string.home_time)} ${getCurrentTime()}";
        setContentView(binding.root)
    }
    //used for getting current date and time
    fun getCurrentTime(): Date = Calendar.getInstance().time
    override fun onBackPressed() {
        backToast = Toast.makeText(this, "Press back again to leave the app.", Toast.LENGTH_LONG)
        //double click to close android application through back bottom navigation button
        if (backPressedTime + 1000 > System.currentTimeMillis()) {
            backToast.cancel()
            super.onBackPressed()
            return
        } else {
            backToast.show()
        }
        backPressedTime = System.currentTimeMillis()
    }




}