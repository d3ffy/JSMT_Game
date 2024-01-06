package com.example.jsmt_game.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jsmt_game.Screen2
import com.example.jsmt_game.ui.theme.JSMT_GameTheme

@Composable
fun Screen2Code(navController: NavHostController) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Text(
            text = "Select Level",
            color = Color.White,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        Button(onClick = {
            navController.navigate("first_Screen")
        }
        ) {
            Text(text = "Back to Title")
        }
        val numbers = (1..10).toList()
        Row (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Yellow)
        ){
            Button(onClick = {
                navController.navigate("third_Screen")
            }
            ) {
                Text(text = "001")
            }

            Button(onClick = {
                navController.navigate("third_Screen")
            }
            ) {
                Text(text = "002")
            }
        }

    }
}
