package com.example.taskscheduler.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.taskscheduler.ui.screens.AddTaskScreen
import com.example.taskscheduler.ui.theme.secondaryColor
import com.example.taskscheduler.ui.viewmodels.AddTaskViewModel
import com.example.taskscheduler.utils.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreenView(
    modifier: Modifier = Modifier,
    selectedNavItem: Routes = Routes.Home,
    view: @Composable (PaddingValues) -> Unit,
    onNavItemClick: (Routes) -> Unit
) {
    var showBottomSheet by remember {
        mutableStateOf(false)
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            containerColor = secondaryColor,
            onDismissRequest = { showBottomSheet = false }
        ) {
            AddTaskScreen(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 20.dp)
            )
        }
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppNavBar(
                route = selectedNavItem.route
            )
        },
        bottomBar = {
            BottomNavigationBar(
                modifier = Modifier.fillMaxWidth(),
                onAddNewTask = {
                    showBottomSheet = true
                },
                onNavItemClick = onNavItemClick
            )
        }
    ) { innerPadding ->
        view(innerPadding)
    }
}