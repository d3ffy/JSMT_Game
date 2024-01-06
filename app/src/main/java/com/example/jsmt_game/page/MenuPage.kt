package com.example.jsmt_game.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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

@Composable
fun MenuPage(navController: NavHostController) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
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
        }) {
            Text(text = "Back to title")
        }
        val numbers = (1..30).toList()

        Column(
            modifier = Modifier
                .background(Color.White),
        ) {
            // Split the list into chunks of 5
            val chunkedNumbers = numbers.chunked(5)

            for (chunk in chunkedNumbers) {
                Row(
                    modifier = Modifier
                    ,
                ) {
                    for (number in chunk) {
                        Button(
                            onClick = {
                                navController.navigate("Screen$number")
                            },
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                                .padding(top = 8.dp, bottom = 8.dp) //
                        ) {
                            Text(text = String.format("%d", number))
                        }
                    }
                }
            }
        }

    }
}