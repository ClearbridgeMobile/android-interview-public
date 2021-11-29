package com.clearbridgemobile.challenge1

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

/**
 * Welcome screen with button and back click handling
 */
@Composable
fun WelcomeScreen(navController: NavController, onBackPressed: () -> Unit) {
  BackHandler {
    onBackPressed()
  }
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(colorResource(R.color.teal_200)),
    contentAlignment = Alignment.Center
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text(
        text = stringResource(R.string.welcome), color = colorResource(R.color.white),
        style = TextStyle(
          color = Color.White,
          fontWeight = FontWeight.Bold,
          textAlign = TextAlign.Center,
          fontSize = 20.sp
        ),
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp)
      )
      Text(
        text = stringResource(R.string.welcome_instructions), color = colorResource(R.color.white),
        style = TextStyle(
          color = Color.White,
          textAlign = TextAlign.Center,
          fontSize = 16.sp
        ),
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp)
      )
      Button(
        onClick = { navController.navigate(Constants.HOME_SCREEN) },
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.purple_500))
      ) {
        Text(
          text = stringResource(R.string.ok), color = colorResource(R.color.white),
          style = TextStyle(
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 16.sp
          ),
          modifier = Modifier
            .padding(3.dp)
        )
      }
    }
  }
}