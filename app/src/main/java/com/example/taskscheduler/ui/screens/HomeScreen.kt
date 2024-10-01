package com.example.taskscheduler.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.taskscheduler.data.Task
import com.example.taskscheduler.ui.components.TaskListItem
import com.example.taskscheduler.ui.components.TaskScreenView
import com.example.taskscheduler.utils.Routes

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavItemClick: (Routes) -> Unit
) {
    val tasks = remember {
        mutableListOf(
            Task(
                title = "Task 1",
                description = "Description 1"
            ),
            Task(
                title = "Task 2",
                description = "Description 2 alsh flaksdh fklasjdhf lkasdh fkljasd flkjahsdlkfjalsdkjf"
            ),
            Task(
                title = "Task 2",
                description = "Description 2 alsh flaksdh fklasjdhf lkasdh fkljasd flkjahsdlkfjalsdkjf"
            ),
            Task(
                title = "Task 2",
                description = "Description 2 alsh flaksdh fklasjdhf lkasdh fkljasd flkjahsdlkfjalsdkjf"
            ),
            Task(
                title = "Task 2",
                description = "Description 2 alsh flaksdh fklasjdhf lkasdh fkljasd flkjahsdlkfjalsdkjf"
            ),
            Task(
                title = "Task 2",
                description = "Description 2 alsh flaksdh fklasjdhf lkasdh fkljasd flkjahsdlkfjalsdkjf"
            ),
            Task(
                title = "Task 2",
                description = "Description 2 alsh flaksdh fklasjdhf lkasdh fkljasd flkjahsdlkfjalsdkjf"
            ),
            Task(
                title = "Task 2",
                description = "Description 2 alsh flaksdh fklasjdhf lkasdh fkljasd flkjahsdlkfjalsdkjf"
            ),
            Task(
                title = "Task 2",
                description = "Description 2 alsh flaksdh fklasjdhf lkasdh fkljasd flkjahsdlkfjalsdkjf"
            ),
            Task(
                title = "Task 2",
                description = "Description 2 alsh flaksdh fklasjdhf lkasdh fkljasd flkjahsdlkfjalsdkjf"
            ),
            Task(
                title = "Task 2",
                description = "Description 2 alsh flaksdh fklasjdhf lkasdh fkljasd flkjahsdlkfjalsdkjf"
            ),
            Task(
                title = "Task 2",
                description = "Description 2 alsh flaksdh fklasjdhf lkasdh fkljasd flkjahsdlkfjalsdkjf"
            ),
        )
    }

    TaskScreenView(
        modifier = modifier,
        view = { innerPadding ->
            Column(
                modifier = modifier
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    items(tasks) { task ->
                        TaskListItem(
                            modifier = Modifier.fillMaxWidth(),
                            task = task
                        )
                    }
                }
            }
        },
        onNavItemClick = onNavItemClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeTopBar(
    modifier: Modifier = Modifier,
    onMenuClick: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null
                )
            }
        },
        title = { Text(text = "Home") }
    )
}