package com.clearbridgemobile.challenge1.vm

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import java.time.LocalDateTime

class HomeViewModel : ViewModel() {

    @RequiresApi(Build.VERSION_CODES.O)
    fun getTime() = LocalDateTime.now()
}