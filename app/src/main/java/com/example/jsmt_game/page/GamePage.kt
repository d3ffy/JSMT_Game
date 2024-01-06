package com.example.jsmt_game.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jsmt_game.gameReset
import com.example.jsmt_game.GameSetup
import com.example.jsmt_game.levelSetup

@Composable
fun GamePage(navController: NavHostController, screenNumber: Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Text(
            text = "Level $screenNumber",
            color = Color.White,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )

        levelSetup(screenNumber)
        GameSetup()

        Button(
            onClick = {
                navController.popBackStack()
                gameReset()
            },
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text(text = "Back to Home")
        }
    }
}