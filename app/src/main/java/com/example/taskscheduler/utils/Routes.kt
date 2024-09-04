package com.example.taskscheduler.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.FolderSpecial
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Routes(
    val route: String,
    val icon: ImageVector? = null,
) {
    data object Home : Routes(route = "Home", icon = Icons.Default.Home)
    data object Calendar : Routes(route = "Calendar", icon = Icons.Default.CalendarToday)
    data object About : Routes(route = "About", icon = Icons.Default.Person)
    data object Bookmarks : Routes(route = "Saved", icon = Icons.Default.Bookmarks)
    data object Folders : Routes(route = "Folders", icon = Icons.Default.FolderSpecial)
}
