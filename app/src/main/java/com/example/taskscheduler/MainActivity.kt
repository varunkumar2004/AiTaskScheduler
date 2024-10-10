package com.example.taskscheduler

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskscheduler.ui.components.TaskView
import com.example.taskscheduler.ui.screens.HomeScreen
import com.example.taskscheduler.ui.screens.TaskScreenView
import com.example.taskscheduler.ui.theme.TaskSchedulerTheme
import com.example.taskscheduler.ui.viewmodels.HomeViewModel
import com.example.taskscheduler.utils.TaskScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            val viewModel = hiltViewModel<HomeViewModel>()


            TaskSchedulerTheme {
                TaskView(
                    modifier = Modifier,
                    onActionButtonClick = {

                    },
                    onNavItemClick = {

                    },
                    view = {
                        val screenModifier = Modifier
                            .fillMaxSize()

                        HomeScreen(
                            modifier = screenModifier,
                            onNavItemClick = { route ->
//                                        navController.navigate(route.route)
                            }
                        )

//                        NavHost(
//                            navController = navController,
//                            startDestination = HomeScreen
//                        ) {
//                            composable<HomeScreen> {
//                                HomeScreen(
//                                    modifier = screenModifier,
//                                    onNavItemClick = { route ->
////                                        navController.navigate(route.route)
//                                    }
//                                )
//                            }
////
//                            composable<TaskScreen> {
////                                navController.navigate(HomeScreen(route = "nothing"))
//                            }
//                        }
                    }
                )

//                NavHost(
//                    navController = navController,
//                    startDestination = Routes.Home.route
//                ) {
//                    composable(route = Routes.Home.route) {
//                        HomeScreen(
//                            modifier = Modifier
//                                .fillMaxSize(),
//                            onNavItemClick = { route ->
//                                navController.navigate(route.route)
//                            }
//                        )
//                    }
//
//                    composable(route = Routes.Folders.route) {
//                        FolderScreen(
//                            modifier = Modifier
//                                .fillMaxSize()
//                        )
//                    }
//
//                    composable(route = Routes.About.route) {
//                        AboutScreen(
//                            modifier = Modifier
//                                .fillMaxSize()
//                        )
//                    }
//
//                    composable(route = Routes.Search.route) {
//                        TaskSearchScreen(
//                            modifier = Modifier.fillMaxSize(),
//                            onNavItemClick = { route ->
//                                navController.navigate(route.route)
//                            }
//                        )
//                    }
//                }
            }
        }
    }
}

@Serializable
object HomeScreen

@Serializable
object SearchScreen
