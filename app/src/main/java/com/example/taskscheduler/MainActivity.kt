package com.example.taskscheduler

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskscheduler.ui.screens.AboutScreen
import com.example.taskscheduler.ui.screens.FolderScreen
import com.example.taskscheduler.ui.screens.HomeScreen
import com.example.taskscheduler.ui.screens.TaskSearchScreen
import com.example.taskscheduler.ui.theme.TaskSchedulerTheme
import com.example.taskscheduler.utils.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            var selectedRoute by remember {
                mutableStateOf<Routes>(Routes.Home)
            }

            val navController = rememberNavController()

            TaskSchedulerTheme {
                NavHost(
                    navController = navController,
                    startDestination = Routes.Home.route
                ) {
                    composable(route = Routes.Home.route) {
                        HomeScreen(
                            modifier = Modifier
                                .fillMaxSize(),
                            onNavItemClick = { route ->
                                navController.navigate(route.route)
                            }
                        )
                    }

                    composable(route = Routes.Folders.route) {
                        FolderScreen(
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }

                    composable(route = Routes.About.route) {
                        AboutScreen(
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }

                    composable(route = Routes.Search.route) {
                        TaskSearchScreen(
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}