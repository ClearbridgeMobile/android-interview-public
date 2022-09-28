package com.utils

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Typeface
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.preference.PreferenceManager
import android.provider.Settings
import android.telephony.TelephonyManager
import android.text.TextUtils
import android.util.Base64
import android.util.TypedValue
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.view.inputmethod.InputMethodManager
import android.webkit.MimeTypeMap
import org.json.JSONException
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.io.File
import java.math.BigDecimal
import java.net.URLDecoder
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.text.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Created by Viv'Ek on 28-Sept-22.
 */
internal object Utils {
    fun setPref(c: Context, pref: String, `val`: String) {
        val e = PreferenceManager.getDefaultSharedPreferences(c).edit()
        e.putString(pref, `val`)
        e.apply()
    }

    fun getPref(c: Context, pref: String, `val`: String): String? {
        return PreferenceManager.getDefaultSharedPreferences(c).getString(pref,
                `val`)
    }

    fun setPref(c: Context, pref: String, `val`: Boolean) {
        val e = PreferenceManager.getDefaultSharedPreferences(c).edit()
        e.putBoolean(pref, `val`)
        e.apply()
    }

    fun getPref(c: Context, pref: String, `val`: Boolean): Boolean {
        return PreferenceManager.getDefaultSharedPreferences(c).getBoolean(
                pref, `val`)
    }

    fun delPref(c: Context, pref: String) {
        val e = PreferenceManager.getDefaultSharedPreferences(c).edit()
        e.remove(pref)
        e.apply()
    }

    fun setPref(c: Context, pref: String, `val`: Int) {
        val e = PreferenceManager.getDefaultSharedPreferences(c).edit()
        e.putInt(pref, `val`)
        e.apply()

    }

    fun getPref(c: Context, pref: String, `val`: Int): Int {
        return PreferenceManager.getDefaultSharedPreferences(c).getInt(pref,
                `val`)
    }

    fun setPref(c: Context, pref: String, `val`: Long) {
        val e = PreferenceManager.getDefaultSharedPreferences(c).edit()
        e.putLong(pref, `val`)
        e.apply()
    }

    fun getPref(c: Context, pref: String, `val`: Long): Long {
        return PreferenceManager.getDefaultSharedPreferences(c).getLong(pref,
                `val`)
    }

    fun setPref(c: Context, file: String, pref: String, `val`: String) {
        val settings = c.getSharedPreferences(file,
                Context.MODE_PRIVATE)
        val e = settings.edit()
        e.putString(pref, `val`)
        e.apply()

    }

    fun getPref(c: Context, file: String, pref: String, `val`: String): String? {
        return c.getSharedPreferences(file, Context.MODE_PRIVATE).getString(
                pref, `val`)
    }

    fun validateEmail(target: CharSequence): Boolean {
        return if (TextUtils.isEmpty(target)) {
            false
        } else {
            android.util.Patterns.EMAIL_ADDRESS.matcher(target)
                    .matches()
        }
    }

    fun validate(target: String, pattern: String): Boolean {
        if (TextUtils.isEmpty(target)) {
            return false
        } else {
            val r = Pattern.compile(pattern)
            return r.matcher(target).matches()
        }
    }

    fun isAlphaNumeric(target: String): Boolean {
        if (TextUtils.isEmpty(target)) {
            return false
        } else {
            val r = Pattern.compile("^[a-zA-Z0-9]*$")
            return r.matcher(target)
                    .matches()
        }
    }

    fun isNumeric(target: String): Boolean {
        if (TextUtils.isEmpty(target)) {
            return false
        } else {
            val r = Pattern.compile("^[0-9]*$")
            return r.matcher(target)
                    .matches()
        }
    }

    fun getDeviceWidth(context: Context): Int {
        try {
            val metrics = context.resources.displayMetrics
            return metrics.widthPixels
        } catch (e: Exception) {
            sendExceptionReport(e)
        }

        return 480
    }

    fun getDeviceHeight(context: Context): Int {
        try {
            val metrics = context.resources.displayMetrics
            return metrics.heightPixels
        } catch (e: Exception) {
            sendExceptionReport(e)
        }

        return 800
    }

    fun isInternetConnected(mContext: Context?): Boolean {
        var outcome = false

        try {
            if (mContext != null) {
                val cm = mContext
                        .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

                val networkInfos = cm.allNetworkInfo

                for (tempNetworkInfo in networkInfos) {
                    if (tempNetworkInfo.isConnected) {
                        outcome = true
                        break
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return outcome
    }

    fun getDeviceId(c: Context): String {
        var aid: String?
        try {
            aid = ""
            aid = Settings.Secure.getString(c.contentResolver,
                    "android_id")
            if (aid == null) {
                aid = "No DeviceId"
            } else if (aid.length <= 0) {
                aid = "No DeviceId"
            }
        } catch (e: Exception) {
            sendExceptionReport(e)
            aid = "No DeviceId"
        }
        return aid!!
    }

    fun random(min: Float, max: Float): Float {
        return (min + Math.random() * (max - min + 1)).toFloat()
    }

    fun random(min: Int, max: Int): Int {
        return Math.round((min + Math.random() * (max - min + 1)).toFloat())
    }

    fun hasFlashFeature(context: Context): Boolean {
        return context.packageManager.hasSystemFeature(
                PackageManager.FEATURE_CAMERA_FLASH)
    }

    fun hasCameraFeature(context: Context): Boolean {
        return context.packageManager.hasSystemFeature(
                PackageManager.FEATURE_CAMERA)
    }

    fun hideKeyBoard(c: Context, v: View) {
        val imm = c
                .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken, 0)
    }


    fun getBold(c: Context): Typeface? {
        try {
            return Typeface.createFromAsset(c.assets,
                    "Roboto-Bold.ttf")
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    fun getNormal(c: Context): Typeface? {
        try {
            return Typeface.createFromAsset(c.assets,
                    "Roboto-Regular.ttf")
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    fun passwordValidator(password: String): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        //        String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
        val PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{6,15}$"


        pattern = Pattern.compile(PASSWORD_PATTERN)
        matcher = pattern.matcher(password)
        return matcher.matches()
    }

    fun sendExceptionReport(e: Exception) {
        e.printStackTrace()

        try {
            // Writer result = new StringWriter();
            // PrintWriter printWriter = new PrintWriter(result);
            // e.printStackTrace(printWriter);
            // String stacktrace = result.toString();
            // new CustomExceptionHandler(c, URLs.URL_STACKTRACE)
            // .sendToServer(stacktrace);
        } catch (e1: Exception) {
            e1.printStackTrace()
        }

    }
}
