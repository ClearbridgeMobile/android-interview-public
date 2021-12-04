package com.clearbridgemobile.challenge1.navigator

import android.content.Context
import android.content.Intent
import com.clearbridgemobile.challenge1.ui.HomeActivity
import com.clearbridgemobile.challenge1.ui.WelcomeActivity
import com.clearbridgemobile.challenge1.util.Constants

fun navigate( screen: Constants.Companion.Screens ,context : Context) {
    val intent = when (screen) {
        Constants.Companion.Screens.HOME_SCREEN -> Intent(context, HomeActivity::class.java)
        else -> Intent(context, WelcomeActivity::class.java)
    }

    context.startActivity(intent)
}