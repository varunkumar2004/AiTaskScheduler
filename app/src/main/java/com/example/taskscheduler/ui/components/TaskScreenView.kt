package com.example.taskscheduler.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
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