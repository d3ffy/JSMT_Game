package com.example.jsmt_game

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jsmt_game.page.Screen1Code
import com.example.jsmt_game.page.Screen2Code
import com.example.jsmt_game.page.Screen3Code
import com.example.jsmt_game.ui.theme.JSMT_GameTheme

@Composable
fun PageSelector(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "first_Screen"){
        composable("first_Screen"){
            Screen1(navController = navController)
        }
        composable("second_Screen"){
            Screen2(navController = navController)
        }
        composable("third_Screen"){
            Screen3(navController = navController)
        }
    }
}

@Composable
fun Screen1(navController: NavHostController) {
    Screen1Code(navController = navController)
}

@Composable
fun Screen2(navController: NavHostController) {
    Screen2Code(navController = navController)
}

@Composable
fun Screen3(navController: NavHostController) {
    Screen3Code(navController = navController)
}

@Preview
@Composable
fun Preview() {
    JSMT_GameTheme {
        Screen2(navController = rememberNavController())
    }
}