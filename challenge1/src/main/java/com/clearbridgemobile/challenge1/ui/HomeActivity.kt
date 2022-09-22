package com.clearbridgemobile.challenge1.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.clearbridgemobile.challenge1.R
import com.clearbridgemobile.challenge1.databinding.ActivityHomeBinding
import com.clearbridgemobile.challenge1.vm.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var navController: NavController
    private val viewModel: BaseViewModel by viewModels()
    private var welcomeScreenState: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setWelcomeScreenState()
        setUpNavController()
        setUpFragmentsBasedOnWelcomeScreenState()

    }

    private fun setUpFragmentsBasedOnWelcomeScreenState() {
        when (welcomeScreenState) {
            true -> {
                navController.navigate(R.id.gotoHomeFragment)
            }
            false -> {
                navController.navigate(R.id.gotoWelcomeFragment)
            }
        }
    }

    private fun setWelcomeScreenState() {
        welcomeScreenState = viewModel.getWelcomeScreenState()
    }

    private fun setUpNavController() {
        navController = Navigation.findNavController(this, R.id.activitiesFragmentNavHost)
    }

    override fun onSupportNavigateUp(): Boolean {
        // this will return the control to nav controller to control the back button in toolbar and also device back button.
        // here null is for drawer layout as no drawer layout is used.
        return NavigationUI.navigateUp(navController, null)
    }

}