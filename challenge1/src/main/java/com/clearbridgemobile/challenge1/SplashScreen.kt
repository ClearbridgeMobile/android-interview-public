package com.clearbridgemobile.challenge1

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(
    navController: NavController,
    viewModel: MainActivityViewModel,
) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3_000
        )
    )

    val state = viewModel.state.collectAsState()
    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(Screen.Welcome.route)

        if (state.value.status == WelcomeScreenStatus.NEVER_SHOWN) {
            navController.navigate(Screen.Welcome.route)
        } else {
            navController.navigate(Screen.Home.route)
        }
    }

    SplashScreen(alpha = alphaAnim.value)
}

@Composable
fun SplashScreen(alpha: Float) {
    Box(
        modifier = Modifier
            .background(color = colorResource(id = R.color.purple_200))
            .fillMaxSize()
            .alpha(alpha = alpha),
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
    SplashScreen(alpha = 1f)
}
