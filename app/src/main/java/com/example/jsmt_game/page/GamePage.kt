package com.example.jsmt_game.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jsmt_game.GameSetup
import com.example.jsmt_game.gameReset
import com.example.jsmt_game.heart
import com.example.jsmt_game.isFailed
import com.example.jsmt_game.isWin
import com.example.jsmt_game.levelSetup
import com.example.jsmt_game.ui.theme.MinecraftFontFamily

@Composable
fun GamePage(navController: NavHostController, screenNumber: Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFedc2ef))
    ) {
        Text(
            text = "Level $screenNumber",
            color = Color.White,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = MinecraftFontFamily,
            modifier = Modifier.offset(y = (-30).dp)
        )

        levelSetup(screenNumber)
        GameSetup()



        Button(
            onClick = {
                gameReset()
                navController.navigate("menu_Screen")
            },
            modifier = Modifier.padding(top = 20.dp),
            colors =  ButtonDefaults.buttonColors(Color(0xFFFF69B4))

        ) {
            Text(text = "Back To Home",
                fontFamily = MinecraftFontFamily
            )
        }

        Text(text = if (isWin && !isFailed) "Yeah! You Passed!"
            else if (isFailed && !isWin) "Nice try"
            else "",
            fontFamily = MinecraftFontFamily
        )
    }
}