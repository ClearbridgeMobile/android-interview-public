package com.clearbridgemobile.challenge1.ui.welcome

import android.os.Bundle
import android.view.View
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.clearbridgemobile.challenge1.R
import com.clearbridgemobile.challenge1.databinding.FragmentWelcomeBinding
import com.clearbridgemobile.challenge1.ui.common.fragment.BaseFragment

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding, WelcomeViewModel>() {
    override var viewModelBindingVariable: Int = BR.viewModel
    override var layoutResId: Int = R.layout.fragment_welcome
    override fun provideViewModel(): WelcomeViewModel {
        return ViewModelProvider(this, viewModelFactory).get(WelcomeViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutBinding.buttonOk.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToHomeFragment())
        }
    }
}