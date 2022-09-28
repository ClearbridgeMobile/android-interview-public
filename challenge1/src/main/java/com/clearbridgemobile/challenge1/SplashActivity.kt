package com.clearbridgemobile.challenge1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.utils.Constant
import com.utils.Debug
import com.utils.Utils

/**
 * Created by Viv'Ek on 28-Sept-22.
 */

class SplashActivity : BaseActivity() {

    internal var TAG = "SplashActivity"
    internal var handler = Handler()
//    internal lateinit var imageLoader: ImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        if (Utils.isInternetConnected(getActivity())) {
//            GCMUtilities(getActivity()).initGCM()

            //            getUpdateVersion();
            //            startApplication(3000);
//            if (Utils.isLocationProviderEnabled(getActivity())) {
            startApplication(3000)
//            } else {
//                handler.post(postLocationDialog)
//            }
//            Utils.getHashKey(getActivity())
        } else {
            startApplication(3000)
        }
    }

    private fun startApplication(sleepTime: Long) {
        handler.postDelayed(startApp, sleepTime)
    }

    internal var startApp: Runnable = object : Runnable {
        override fun run() {
            handler.removeCallbacks(this)
            Debug.e(TAG, "startApp")
            var isIntroDone = Utils.getPref(getActivity(), Constant.IS_INTRO_DONE, false)
            if (isIntroDone) {
                val i = Intent(getActivity(), MainActivity::class.java)
                startActivity(i)
                finish()
            } else {
                val i = Intent(getActivity(), WelcomeActivity::class.java)
                startActivity(i)
                finish()
            }
        }
    }

    internal var checkConnection: Runnable = object : Runnable {
        override fun run() {
            Debug.e(TAG, "checkConnection")
            if (Utils.isInternetConnected(getActivity())) {
//                splashMsg.setText(getString(R.string.connected))
                handler.removeCallbacks(this)
                if (Utils.isInternetConnected(getActivity())) {
                    startApplication(3000)
                } else {
//                    handler.post(mPostInternetConDialog)
                }
            } else {
//                if (count != 0) {
//                    splashMsg.setText(
//                        String.format(
//                            getString(R.string.retrying), "" + count--
//                        )
//                    )
//                    handler.postDelayed(this, 3000)
//                } else {
//                    splashMsg.setText(R.string.finishing)
//                    finish()
//                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == Constant.REQ_CODE_SETTING) {
//            splashMsg.setVisibility(View.VISIBLE)
//            handler.post(checkConnection)
//        }
    }

    override fun onDestroy() {
        super.onDestroy()
        try {
            handler.removeCallbacks(startApp)
            handler.removeCallbacks(checkConnection)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}