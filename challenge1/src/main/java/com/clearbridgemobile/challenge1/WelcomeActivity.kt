package com.example.demoapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    val PREFERENCE_NAME="SharedPreferenceExample"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val prefs = getSharedPreferences(
            PREFERENCE_NAME, Context.MODE_PRIVATE
        )

        val text: TextView = findViewById(R.id.textview_first) as TextView
        val next: Button = findViewById(R.id.button_first) as Button
        text.setText("Welcome \n Press Next to Proceed")
        next.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            prefs.edit().putBoolean("key",true).commit();
            startActivity(intent)
        }

    }
}