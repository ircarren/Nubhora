package com.ircarren.nubhora.navigation

sealed class AppScreen(val route: String) {
    object FirstScreen : AppScreen("first")
    object SecondScreen : AppScreen("second")
}
