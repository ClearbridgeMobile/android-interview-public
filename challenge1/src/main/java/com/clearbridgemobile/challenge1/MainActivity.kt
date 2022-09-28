package com.clearbridgemobile.challenge1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import org.w3c.dom.Text
import java.util.*

class MainActivity : BaseActivity() {

    lateinit var tvTime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init() {
        tvTime = findViewById(R.id.tvTime) as TextView
        tvTime.setText(getString(R.string.home_time) + " " + getCurrentTime())
    }

    fun getCurrentTime(): Date = Calendar.getInstance().time

}