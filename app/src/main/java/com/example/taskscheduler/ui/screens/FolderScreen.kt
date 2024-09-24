package com.example.taskscheduler.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskscheduler.data.Task
import com.example.taskscheduler.ui.components.TaskScreenView
import com.example.taskscheduler.ui.theme.primaryColor
import com.example.taskscheduler.ui.theme.secondaryColor

@Composable
fun FolderScreen(
    modifier: Modifier = Modifier
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

    val categories = listOf(
        "Personal",
        "Work",
        "Family",
        "School",
        "Other"
    )

    TaskScreenView(
        view = { pd ->
            Column(
                modifier = modifier
                    .padding(pd)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    items(categories) { category ->
                        TextButton(
                            colors = ButtonDefaults.textButtonColors(
                                containerColor = primaryColor,
                                contentColor = secondaryColor
                            ),
                            onClick = { /*TODO*/ }
                        ) {
                            Text(
                                text = category
                            )
                        }
                    }
                }

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    items(tasks) { task ->
                        TaskListItem(
                            modifier = Modifier.fillMaxWidth(),
                            showCategories = false,
                            task = task
                        )
                    }
                }

            }
        },
        onNavItemClick = {

        }
    )
}

@Composable
fun CategoryContainer(
    modifier: Modifier = Modifier,
    category: String
) {
    Box(
        modifier = modifier
            .background(secondaryColor),
        contentAlignment = Alignment.Center
    ) {
        Text(text = category)
    }
}

@Preview(showBackground = true)
@Composable
private fun FolderPrev() {
    FolderScreen(
        Modifier.fillMaxSize()
    )
}