package com.ircarren.nubhora

object TimeProvider {
    val RegistroHorario = listOf(
        Registros("00:36:37", "..."),
        Registros("08:06:37", "15:36:37"),
        Registros("08:01:28", "15:00:37"),
        Registros("08:00:37", "15:00:37"),
        Registros("08:10:45", "15:10:59"),
        Registros("07:58:37", "14:58:43"),
        Registros("08:00:37", "15:00:37"),
        Registros("08:00:37", "15:00:37"),
        Registros("08:00:37", "15:00:37"),
        Registros("08:00:37", "15:00:37"),
        Registros("08:00:37", "15:00:37"),
        Registros("08:00:37", "15:00:37"),
    )
}

data class Registros(var entrada: String, var salida: String) {

}

