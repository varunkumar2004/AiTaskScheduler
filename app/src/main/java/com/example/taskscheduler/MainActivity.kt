package com.example.taskscheduler

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskscheduler.ui.components.BottomNavigationBar
import com.example.taskscheduler.ui.components.TopAppNavBar
import com.example.taskscheduler.ui.screens.HomeScreen
import com.example.taskscheduler.ui.theme.TaskSchedulerTheme
import com.example.taskscheduler.utils.Routes

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            var selectedRoute by remember {
                mutableStateOf<Routes>(Routes.Home)
            }

            TaskSchedulerTheme {
                Scaffold(
                    topBar = {
                        TopAppNavBar(
                            modifier = Modifier.fillMaxWidth(),
                            route = selectedRoute.route
                        )
                    },
                    bottomBar = {
                        BottomNavigationBar(
                            modifier = Modifier.fillMaxWidth(),
                            onNavItemClick = {route ->
                                selectedRoute = route
                            }
                        )
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Routes.Home.route
                    ) {
                        composable(route = Routes.Home.route) {
                            HomeScreen(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding)
                            )
                        }
                    }
                }
            }
        }
    }
}