package com.clearbridgemobile.challenge1

import android.os.Bundle
import androidx.activity.ComponentActivity
import java.util.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun getCurrentTime(): Date = Calendar.getInstance().time
}
