package com.fcinar.playmakerapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CreatePlayerScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Oyuncu Oluştur")
    }
}