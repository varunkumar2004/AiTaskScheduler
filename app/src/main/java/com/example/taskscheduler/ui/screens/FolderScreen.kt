package com.example.taskscheduler.ui.screens

import android.hardware.lights.Light
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskscheduler.data.Task
import com.example.taskscheduler.data.TaskCategory
import com.example.taskscheduler.ui.components.BookmarkContainerView
import com.example.taskscheduler.ui.components.TopAppNavBar
import com.example.taskscheduler.utils.Routes

@Composable
fun FolderScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppNavBar(
                route = Routes.Folders.route
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            BookmarkContainerView(
                modifier = Modifier
                    .fillMaxWidth(),
                category = TaskCategory(
                    title = "Personal",
                    tasks = listOf(
                        Task(
                            title = "Task 1",
                            description = "Description 1"
                        ),
                        Task(
                            title = "Task 2",
                            description = "nothing to do here"
                        )
                    )
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FolderPrev() {
    FolderScreen(
        Modifier.fillMaxSize()
    )
}