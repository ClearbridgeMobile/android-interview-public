package com.clearbridgemobile.challenge1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun WelcomeScreen(
    navController: NavController,
) {
    WelcomeScreen(
        onClickOkButton = {
            navController.navigate(Screen.Home.route)
        }
    )
}

@Composable
fun WelcomeScreen(
    onClickOkButton: () -> Unit,
) {
    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.teal_200))
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(
                space = dimensionResource(id = R.dimen.spacer),
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = stringResource(id = R.string.welcome))
            Text(text = stringResource(id = R.string.welcome_instructions))
            Button(
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = colorResource(id = R.color.purple_200)
                ),
                onClick = onClickOkButton
            ) {
                Text(text = stringResource(id = R.string.ok), color = colorResource(id = R.color.white))
            }
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen {}
}
