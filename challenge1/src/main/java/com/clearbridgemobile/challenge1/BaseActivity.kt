package com.clearbridgemobile.challenge1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.utils.Constant

/**
 * Created by Viv'Ek on 28-Sept-22.
 */

open class BaseActivity : AppCompatActivity() {


    internal lateinit var toast: Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)

        toast = Toast.makeText(getActivity(), "", Toast.LENGTH_LONG)

        val intentFilter = IntentFilter()
        intentFilter.addAction(Constant.FINISH_ACTIVITY)

        commonReciever = MyEventServiceReciever()
        LocalBroadcastManager.getInstance(this).registerReceiver(
                commonReciever, intentFilter)
    }

    fun setTitleText(text: String) {
        try {
//            tvTitleText.text = text
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    internal lateinit var commonReciever: MyEventServiceReciever

    internal inner class MyEventServiceReciever : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            try {
                if (intent.action!!.equals(Constant.FINISH_ACTIVITY, true)) {
                    finish()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getActivity(): BaseActivity {
        return this
    }

    fun finishActivity() {
        if (getActivity() is MainActivity) {

        } else {
            getActivity().finish()
        }
    }

    fun initBack(b: Boolean) {
        val imgBack = findViewById<View>(R.id.imgBack) as ImageView
        if (b) {
            imgBack.visibility = View.VISIBLE
            imgBack.setOnClickListener { finish() }
        } else {
            imgBack.visibility = View.GONE
        }
    }

    override fun onBackPressed() {
        try {
//            if (result.isDrawerOpen) {
//                result.closeDrawer()
//            } else {
                super.onBackPressed()
//            }
        } catch (e: Exception) {
            super.onBackPressed()
        }
    }

}