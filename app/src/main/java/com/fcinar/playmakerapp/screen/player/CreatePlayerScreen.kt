package com.fcinar.playmakerapp.screen.player

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.fcinar.playmakerapp.R
import com.fcinar.playmakerapp.component.TopAppBarComponent

@Composable
@ExperimentalMaterial3Api
fun CreatePlayerScreen(navController: NavController) {
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
                .fillMaxSize()
        ) {
            Text(text = "Oyuncu Oluştur")
        }
    }
}