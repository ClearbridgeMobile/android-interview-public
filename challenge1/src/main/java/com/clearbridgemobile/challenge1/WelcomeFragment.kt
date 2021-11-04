package com.clearbridgemobile.challenge1

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_welcome.*

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_ok.setOnClickListener {
            saveWelcome()
            fragmentManager?.run{
                beginTransaction()
                    .replace(R.id.frame_container, HomeFragment())
                    .commit()
            }
        }
    }

    private fun saveWelcome() {
        val sharedPreferences: SharedPreferences = requireContext().getSharedPreferences(
            resources.getString(R.string.app_name),
            Context.MODE_PRIVATE
        )
        sharedPreferences.edit()
            .putBoolean(WELCOME_PREFERENCES_KEY, true)
            .apply()
    }

    companion object {
        private const val WELCOME_PREFERENCES_KEY = "WELCOME_PREFERENCES_KEY"
    }
}