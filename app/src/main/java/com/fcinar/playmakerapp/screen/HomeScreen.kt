package com.fcinar.playmakerapp.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fcinar.playmakerapp.Destinations
import com.fcinar.playmakerapp.component.ElevatedCardComponent

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            ElevatedCardComponent(
                text = "Oyuncu Oluştur",
                onClick = {
                    navController.navigate(Destinations.CREATE_PLAYER.route)
                })
            ElevatedCardComponent(
                text = "Kadro Oluştur",
                onClick = {
                    navController.navigate(Destinations.CREATE_SQUAD.route)
                })
        }
    }
}