package com.clearbridgemobile.challenge1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .background(color = colorResource(id = R.color.purple_200))
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_live_tv_48),
            contentDescription = "Logo",
        )
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}
