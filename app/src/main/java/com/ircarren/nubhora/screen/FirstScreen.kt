package com.ircarren.nubhora.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ircarren.nubhora.navigation.AppScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(navController: NavController) {
    BodyFirst(navController = navController)
}

@Composable
fun BodyFirst(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "First Screen")
        Button(onClick = { navController.navigate(route= AppScreen.SecondScreen.route+"/Texto enviado de pantalla a pantalla") }) {
            Text(text = "Go to Second Screen")
        }
    }
}
