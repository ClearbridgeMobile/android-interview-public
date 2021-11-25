package com.clearbridgemobile.challenge1.ui.home


import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.clearbridgemobile.challenge1.R
import com.clearbridgemobile.challenge1.databinding.FragmentHomeBinding
import com.clearbridgemobile.challenge1.ui.common.fragment.BaseFragment
import java.util.*

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override var viewModelBindingVariable: Int = BR.viewModel
    override var layoutResId: Int = R.layout.fragment_home
    lateinit var onBackPressedCallback: OnBackPressedCallback
    override fun provideViewModel(): HomeViewModel {
        return ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
    }


    fun getCurrentTime(): Date = Calendar.getInstance().time


    override fun onPause() {
        super.onPause()
        onBackPressedCallback.remove()
    }


    override fun onResume() {
        super.onResume()
        layoutBinding.txtTime.text = getString(R.string.home_time, getCurrentTime())
        onBackPressedCallback = requireActivity().onBackPressedDispatcher.addCallback {
           requireActivity().finish()
        }
    }
}