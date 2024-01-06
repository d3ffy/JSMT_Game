package com.example.jsmt_game.page

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jsmt_game.ui.theme.JSMT_GameTheme

@Composable
fun MenuPage(navController: NavHostController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Select Level",
            color = Color.Black,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 30.dp)
        )
        val numbers = (1..20).toList()
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)

        ) {
            val chunkedNumbers = numbers.chunked(5)

            for (chunk in chunkedNumbers) {
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    for (number in chunk) {
                        Button(
                            onClick = {
                                navController.navigate("Screen$number")
                            },
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                                .padding(top = 8.dp, bottom = 8.dp)
                                .background(Color.White)
                                .clickable {
                                    navController.navigate("Screen$number")
                                },
                            colors =  ButtonDefaults.buttonColors(Color(0xFFFFFedc2ef)),

                        ) {
                            Text(text = String.format("%d", number))
                        }
                        Spacer(modifier = Modifier.width(1.dp))
                    }
                }
            }
        }
        Button(
            onClick = {
                navController.navigate("title_Screen")
            }
        ) {
            Text(text = "Back to Title")
        }
    }
}

@Preview
@Composable
fun Preview() {
    JSMT_GameTheme {
        MenuPage(navController = rememberNavController())
    }
}