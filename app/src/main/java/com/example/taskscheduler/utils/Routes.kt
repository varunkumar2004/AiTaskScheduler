package com.example.taskscheduler.utils

sealed class Routes(
    val route: String
) {
    data object Home: Routes("home")
//    data object Home: Routes("home")
//    data object Home: Routes("home")
}
