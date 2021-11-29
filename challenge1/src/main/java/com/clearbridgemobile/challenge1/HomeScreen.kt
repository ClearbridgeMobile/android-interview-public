package com.clearbridgemobile.challenge1

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import java.util.*

/**
 * Home Screen
 * Filled with White color, Shows time and handle back press
 */
@Composable
fun HomeScreen(onBackPressed: () -> Unit) {
  BackHandler {
    onBackPressed()
  }
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(colorResource(R.color.white)),
    contentAlignment = Alignment.Center
  ) {
    Text(text = stringResource(R.string.home_time, getCurrentTime().toString()), color = colorResource(R.color.black))
  }
}


private fun getCurrentTime(): Date = Calendar.getInstance().time
