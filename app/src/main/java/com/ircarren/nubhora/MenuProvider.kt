package com.ircarren.nubhora

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

object MenuProvider {
    val menuItems = listOf(
        MenuDataClass(
            "Inicio", Icons.Filled.Home
        ),
        MenuDataClass(
            "Solicitudes", Icons.Filled.Email
        ),
        MenuDataClass(
            "Empleado", Icons.Filled.Person
        ) ,       MenuDataClass(
                "Equipo", Icons.Filled.Notifications
    ),
        MenuDataClass(
            "Documents", Icons.Filled.List
        )
    )
}

data class MenuDataClass(var name: String, var icon: ImageVector) {

}

