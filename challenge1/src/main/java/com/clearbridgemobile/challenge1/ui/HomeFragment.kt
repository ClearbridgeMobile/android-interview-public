package com.clearbridgemobile.challenge1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.clearbridgemobile.challenge1.R
import com.clearbridgemobile.challenge1.databinding.FragmentHomeBinding
import com.clearbridgemobile.challenge1.vm.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: BaseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.apply {
            time.observe({ lifecycle }) { time ->
                time?.let { currentTime ->
                    binding.txtHomeTime.text =
                        String.format(resources.getString(R.string.home_time), currentTime)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCurrentTime()
    }

    private fun getCurrentTime() {
        viewModel.getCurrentTime()
    }

}