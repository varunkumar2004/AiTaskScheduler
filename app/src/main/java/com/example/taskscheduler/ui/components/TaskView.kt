package com.example.taskscheduler.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.taskscheduler.ui.screens.TaskScreenView
import com.example.taskscheduler.ui.theme.darkPrimaryColor
import com.example.taskscheduler.ui.theme.darkSecondaryColor
import com.example.taskscheduler.utils.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskView(
    modifier: Modifier = Modifier,
    view: @Composable (PaddingValues) -> Unit,
    onActionButtonClick: () -> Unit = {},
    onNavItemClick: (Routes) -> Unit
) {
    var showBottomSheet by remember {
        mutableStateOf(false)
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            containerColor = Color.White,
            onDismissRequest = { showBottomSheet = false }
        ) {
            TaskScreenView(
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

    Scaffold(
        modifier = modifier,
        containerColor = darkPrimaryColor,
        topBar = {
            TopAppNavBar(
                route = "route"
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                onClick = onActionButtonClick
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
//        bottomBar = {
//            BottomNavigationBar(
//                modifier = Modifier.fillMaxWidth(),
//                onAddNewTask = {
//                    showBottomSheet = true
//                },
//                onNavItemClick = onNavItemClick
//            )
//        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            val tabModifier = Modifier
                .height(TextFieldDefaults.MinHeight)

            TabRow(
                selectedTabIndex = 0,
                containerColor = darkPrimaryColor,
                contentColor = darkSecondaryColor,
            ) {
                Tab(
                    modifier = tabModifier,
                    selected = false,
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "All")
                }

                Tab(
                    modifier = tabModifier,
                    selected = false,
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "Completed")
                }
            }

            view(innerPadding)
        }
    }
}