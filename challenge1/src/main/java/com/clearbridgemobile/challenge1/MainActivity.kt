package com.clearbridgemobile.challenge1

import android.os.Bundle
import com.clearbridgemobile.challenge1.databinding.ActivityMainBinding
import com.clearbridgemobile.challenge1.ui.common.activity.BaseActivity
import java.util.*

class MainActivity :  BaseActivity<ActivityMainBinding, MainViewModel>() {

    override var layoutId: Int = R.layout.activity_main
    override var viewModelClass: Class<MainViewModel> = MainViewModel::class.java
    override var viewModelBindingVariable: Int = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


}
