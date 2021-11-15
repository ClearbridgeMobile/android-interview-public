package com.clearbridgemobile.challenge1

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class LaunchFragment : Fragment() {

  private lateinit var sharedPrefs: SharedPreferences

  private val millisInFuture = 3000L
  private val countDownInterval = 1000L

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    sharedPrefs = SharedPreferences(requireContext())
  }

  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_launch, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    timer(millisInFuture, countDownInterval).start()
  }

  private fun timer(finishIn: Long, tickInterval: Long): CountDownTimer {
    return object : CountDownTimer(finishIn, tickInterval) {
      override fun onTick(millisUntilFinished: Long) {}

      override fun onFinish() {
        if (sharedPrefs.skipWelcome)
            findNavController().navigate(R.id.action_launchFragment_to_homeFragment)
        else {
          sharedPrefs.skipWelcome = true
          findNavController().navigate(R.id.action_launchFragment_to_welcomeFragment)
        }
      }
    }
  }

}
