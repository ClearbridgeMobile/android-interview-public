package com.clearbridgemobile.challenge1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.utils.Constant
import com.utils.Utils
import java.util.*

class WelcomeActivity : BaseActivity() {

    lateinit var btnOk: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        init()
    }

    fun init() {
        btnOk = findViewById<Button>(R.id.btnOk)

        btnOk.setOnClickListener {
            Utils.setPref(getActivity(), Constant.IS_INTRO_DONE, true)
            val i = Intent(getActivity(), MainActivity::class.java)
            startActivity(i)
            finish()
        }
    }

    fun getCurrentTime(): Date = Calendar.getInstance().time
}
