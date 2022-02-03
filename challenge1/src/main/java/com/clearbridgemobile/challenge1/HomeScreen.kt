package com.clearbridgemobile.challenge1

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import kotlin.system.exitProcess

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.white))
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(
                space = dimensionResource(id = R.dimen.spacer),
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = stringResource(id = R.string.home_hi))
            Text(text = stringResource(id = R.string.home_time).format(getCurrentTime()))
        }
    }

    BackHandler(enabled = true) {
        exitProcess(0)
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
