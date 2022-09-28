package com.common.view

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import com.utils.Utils

/**
 * Created by Viv'Ek on 28-Sept-22.
 */
class CBButtonViewM : androidx.appcompat.widget.AppCompatButton {

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context) : super(context) {
        init()
    }

    fun init() {
        if (!isInEditMode) {
            try {
                //                if (!Locale.getDefault().toString().startsWith("en"))
//                typeface = Utils.getBold(context)
            } catch (e: Exception) {
            }

        }
    }
}