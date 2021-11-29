package com.clearbridgemobile.challenge1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity: ComponentActivity() {


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      /**
       * initialize navController, viewModel and preference
       */
      val navController = rememberNavController()
      val viewModel: SplashViewModel = viewModel(
        factory = SplashViewModel.provideFactory(PreferenceRepository(this))
      )

      Scaffold {
        NavigationComponent(navController, viewModel) {
          //onBackPressed listener used on welcome and home screen
          finish()
        }
      }
    }
  }

  //Navigation composable component
  @Composable
  fun NavigationComponent(
    navController: NavHostController,
    viewModel: SplashViewModel,
    onBackPressed: () -> Unit
  ) {
    //Start navigation with splash screen
    NavHost(
      navController = navController,
      startDestination = Constants.SPLASH_SCREEN
    ) {

      //Define the composable screens
      composable(Constants.SPLASH_SCREEN) {
        SplashScreen(navController, viewModel)
      }
      composable(Constants.WELCOME_SCREEN) {
        WelcomeScreen(navController = navController, onBackPressed)
      }
      composable(Constants.HOME_SCREEN) {
        HomeScreen(onBackPressed)
      }
    }
  }
}
