package com.clearbridgemobile.challenge1.ui.common.activity

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.clearbridgemobile.challenge1.ui.common.viewmodel.ViewModelFactory
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class BaseActivity<LayoutBinding : ViewDataBinding, VM : ViewModel> :
    AppCompatActivity(), HasAndroidInjector {

    abstract var layoutId: Int
    abstract var viewModelClass: Class<VM>
    abstract var viewModelBindingVariable: Int

    protected lateinit var viewModel: VM
    private var _binding: LayoutBinding? = null
    protected val layoutBinding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>

    @Inject
    lateinit var prefs : SharedPreferences

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        performDataBinding()

    }

    private fun performDataBinding() {
        _binding = DataBindingUtil.setContentView(this, layoutId)
        layoutBinding.lifecycleOwner = this

        viewModel = ViewModelProvider(this, viewModelFactory).get(viewModelClass)
        /* In the xml, bind the viewModel variable to the activity layout's binding */
        setDataBindingVariables(layoutBinding)
        layoutBinding.executePendingBindings()
    }

    private fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }

    /**
     * Override this method when another variable needs to be bind.
     * Be sure to call super().
     */
    private fun setDataBindingVariables(binding: ViewDataBinding) {
        binding.setVariable(viewModelBindingVariable, viewModel)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}