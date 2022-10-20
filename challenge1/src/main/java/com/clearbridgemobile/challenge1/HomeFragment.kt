package com.clearbridgemobile.challenge1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.clearbridgemobile.challenge1.databinding.FragmentHomeBinding
import java.util.*

class HomeFragment : Fragment() {
    private val viewModel: MainViewModel by activityViewModels()

    //Assign the binding variable initially to null and
    //also when the fragment's view is destroyed it has to be set to null again
    private var _binding: FragmentHomeBinding? = null

    //Extract the non null value of binding
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // inflate the layout and bind to the _binding
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // retrieve the entered data by the user
        val time = viewModel.getCurrentTime().toString()
        val formattedTimeString = getString(R.string.home_time, time)
        binding.homeTimeTV.text = formattedTimeString
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}