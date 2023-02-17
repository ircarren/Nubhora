package com.ircarren.nubhora.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ircarren.nubhora.screen.FirstScreen
import com.ircarren.nubhora.screen.SecondScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.FirstScreen.route) {
        composable(route = AppScreen.FirstScreen.route) {
            FirstScreen(navController = navController)
        }
        composable(route = AppScreen.SecondScreen.route+"/{text}") {
            SecondScreen(
                navController = navController,
                text = it.arguments?.getString("text") ?: "No text"
            )
        }
    }
}