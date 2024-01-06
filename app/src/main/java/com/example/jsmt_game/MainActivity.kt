package com.example.jsmt_game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jsmt_game.ui.theme.JSMT_GameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JSMT_GameTheme {
                PageSelector()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JSMT_GameTheme {
        PageSelector()
    }
}