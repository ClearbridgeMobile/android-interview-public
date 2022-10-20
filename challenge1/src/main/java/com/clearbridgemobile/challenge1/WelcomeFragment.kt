package com.clearbridgemobile.challenge1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.clearbridgemobile.challenge1.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private val viewModel: MainViewModel by activityViewModels()

    //Assign the binding variable initially to null and
    //also when the fragment's view is destroyed it has to be set to null again
    private var _binding: FragmentWelcomeBinding? = null

    //Extract the non null value of binding
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // inflate the layout and bind to the _binding
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        // retrieve the Click Event triggered by the user
        // Set it to view model so that it can be further be observed by Activity
        binding.okBtn.setOnClickListener {
            viewModel.setIsOkClickedItem(true)
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}