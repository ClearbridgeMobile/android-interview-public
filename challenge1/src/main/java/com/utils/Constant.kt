package com.utils

import android.os.Environment
import java.io.File

/**
 * Created by Viv'Ek on 28-Sept-22.
 */

internal object Constant {
    val FINISH_ACTIVITY = "finish_activity"

    val FOLDER_NAME = ".kotdemo"
    val CACHE_DIR = ".kotdemo/Cache"

    val IS_INTRO_DONE = "is_intro_done"

    val TMP_DIR = (Environment
            .getExternalStorageDirectory().absolutePath
            + File.separator
            + FOLDER_NAME + "/tmp")

    val PATH = Environment.getExternalStorageDirectory()
            .absolutePath + File.separator + "" + FOLDER_NAME

    val FOLDER_RIDEINN_PATH = (Environment
            .getExternalStorageDirectory().absolutePath
            + File.separator
            + "kotdemo")
}