package com.fcinar.playmakerapp.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fcinar.playmakerapp.Destinations
import com.fcinar.playmakerapp.R
import com.fcinar.playmakerapp.component.ElevatedCardComponent
import com.fcinar.playmakerapp.component.TopAppBarComponent

@Composable
@ExperimentalMaterial3Api
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBarComponent(
                navController = navController,
                title = stringResource(id = R.string.app_name)
            )
        },
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                ElevatedCardComponent(
                    text = "Oyuncu",
                    onClick = {
                        navController.navigate(Destinations.PLAYER.route)
                    })
                ElevatedCardComponent(
                    text = "Kadro",
                    onClick = {
                        navController.navigate(Destinations.SQUAD.route)
                    })
            }
            Row(
                modifier = Modifier
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                ElevatedCardComponent(
                    text = "BlaBla",
                    onClick = {

                    })
                ElevatedCardComponent(
                    text = "BlaBla",
                    onClick = {

                    })
            }
        }
    }
}