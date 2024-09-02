package com.example.taskscheduler.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.taskscheduler.utils.Routes

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    onNavItemClick: (Routes) -> Unit
) {
    var selectedItem by remember {
        mutableStateOf<Routes>(Routes.Home)
    }

//    NavigationBar(
//        modifier = modifier
//    ) {
//        NavigationBarItem(
//            selected = selectedItem == Routes.Home,
//            onClick = { selectedItem = Routes.Home },
//            label = {
//                Text(text = Routes.Home.route)
//            },
//            icon = {
//                Icon(
//                    imageVector = Routes.Home.icon!!,
//                    contentDescription = Routes.Home.route
//                )
//            }
//        )

//        NavigationBarItem(
//            selected = selectedItem == Routes.Calendar,
//            onClick = { selectedItem = Routes.Calendar },
//            label = {
//                Text(text = Routes.Calendar.route)
//            },
//            icon = {
//                Icon(
//                    imageVector = Routes.Calendar.icon!!,
//                    contentDescription = Routes.Calendar.route
//                )
//            }
//        )

        BottomAppBar {
            Row(
                modifier = modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { onNavItemClick(Routes.Home) }
                    ) {
                        Icon(
                            imageVector = Routes.Home.icon!!,
                            contentDescription = Routes.Home.route
                        )
                    }

                    IconButton(
                        onClick = { onNavItemClick(Routes.Bookmarks) }
                    ) {
                        Icon(
                            imageVector = Routes.Bookmarks.icon!!,
                            contentDescription = Routes.Bookmarks.route
                        )
                    }

                    IconButton(
                        onClick = { onNavItemClick(Routes.Folders) }
                    ) {
                        Icon(
                            imageVector = Routes.Folders.icon!!,
                            contentDescription = Routes.Folders.route
                        )
                    }
                }

                IconButton(
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = Color.LightGray,
                        contentColor = Color.Black
                    ),
                    onClick = { onNavItemClick(Routes.Home) }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add task"
                    )
                }

            }
        }

//        NavigationBarItem(
//            selected = selectedItem == Routes.Bookmarks,
//            onClick = { selectedItem = Routes.Bookmarks },
//            label = {
//                Text(text = Routes.Bookmarks.route)
//            },
//            icon = {
//                Icon(
//                    imageVector = Routes.Bookmarks.icon!!,
//                    contentDescription = Routes.Bookmarks.route
//                )
//            }
//        )
//
//        NavigationBarItem(
//            selected = selectedItem == Routes.Folders,
//            onClick = { selectedItem = Routes.Folders },
//            label = {
//                Text(text = Routes.Folders.route)
//            },
//            icon = {
//                Icon(
//                    imageVector = Routes.Folders.icon!!,
//                    contentDescription = Routes.Folders.route
//                )
//            }
//        )
//    }
}