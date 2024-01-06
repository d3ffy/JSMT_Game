package com.example.jsmt_game

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jsmt_game.page.GamePage
import com.example.jsmt_game.page.MenuPage
import com.example.jsmt_game.page.TitlePage

var screenNumber: Int = 0

@Composable
fun PageSelector(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "title_Screen"){
        composable("title_Screen"){
            SelectTitlePage(navController = navController)
        }
        composable("menu_Screen"){
            SelectMenuPage(navController = navController)
        }
        composable("game_Screen"){
            SelectGamePage(navController = navController)
        }
        for (i in 1..30) {
            val screenName = "Screen$i"
            composable(screenName) {
                GamePage(navController = navController, screenNumber = i)
            }
        }
    }
}

@Composable
fun SelectTitlePage(navController: NavHostController) {
    TitlePage(navController = navController)
}

@Composable
fun SelectMenuPage(navController: NavHostController) {
    MenuPage(navController = navController)
}

@Composable
fun SelectGamePage(navController: NavHostController) {
    GamePage(navController = navController, screenNumber)
}
