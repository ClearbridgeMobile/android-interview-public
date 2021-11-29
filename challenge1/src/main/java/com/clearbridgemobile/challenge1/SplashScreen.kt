package com.clearbridgemobile.challenge1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

/**
 * Splash screen
 * filled with purple color, and invoke the view Model timer
 */
@Composable
fun SplashScreen(
  navController: NavController,
  viewModel: SplashViewModel
) {

  val uiState by viewModel.uiState.collectAsState()

  LaunchedEffect(uiState.nextNavigateRoute) {
    if (uiState.nextNavigateRoute.isNotEmpty()) {
      navController.navigate(uiState.nextNavigateRoute)
    }
  }

  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(colorResource(R.color.purple_200)),
    contentAlignment = Alignment.Center
  ) {
    Image(painter = painterResource(R.drawable.baseline_live_tv_48), "tv")
  }

  LaunchedEffect(Constants.TIMER) {
    viewModel.startTimer()
  }
}

