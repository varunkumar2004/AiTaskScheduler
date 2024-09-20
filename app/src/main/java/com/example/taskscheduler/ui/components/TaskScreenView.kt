package com.example.taskscheduler.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.taskscheduler.utils.Routes

@Composable
fun TaskScreenView(
    modifier: Modifier = Modifier,
    selectedNavItem: Routes = Routes.Home,
    view: @Composable (PaddingValues) -> Unit,
    onNavItemClick: (Routes) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppNavBar(
                route = selectedNavItem.route
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                onClick = { /*TODO*/ }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
        bottomBar = {
            BottomNavigationBar(
                selectedItem = selectedNavItem,
                onNavItemClick = onNavItemClick
            )
        }
    ) { innerPadding ->
        view(innerPadding)
    }
}