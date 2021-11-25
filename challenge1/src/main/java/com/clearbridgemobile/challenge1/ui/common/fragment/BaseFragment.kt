package com.clearbridgemobile.challenge1.ui.common.fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.clearbridgemobile.challenge1.ui.common.viewmodel.ViewModelFactory
import com.clearbridgemobile.challenge1.MainViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


/**
 * Abstract base class for fragment creation.
 *
 * Base implementation of the basic needs and actions of a fragment class
 *
 * @param LayoutBinding Reference to the fragment's layout binding class
 * @param VM Reference to the fragment's ViewModel class
 */

abstract class BaseFragment<LayoutBinding : ViewDataBinding, VM : ViewModel> :
    Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    protected lateinit var viewModel: VM
    abstract var viewModelBindingVariable: Int
    protected abstract var layoutResId: Int

    private var _binding: LayoutBinding? = null
    protected val layoutBinding get() = _binding!!

    protected lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var prefs : SharedPreferences

    abstract fun provideViewModel(): VM

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        viewModel = provideViewModel()
        mainViewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(
            MainViewModel::class.java
        )


        setHasOptionsMenu(true)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        return layoutBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDataBindingVariables(layoutBinding)
        layoutBinding.lifecycleOwner = this
        layoutBinding.executePendingBindings()
    }

    protected open fun setDataBindingVariables(binding: ViewDataBinding) {
        binding.setVariable(viewModelBindingVariable, viewModel)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun performDependencyInjection() = run { AndroidSupportInjection.inject(this) }



}