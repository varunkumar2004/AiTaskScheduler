package com.example.taskscheduler.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen() {
    Scaffold(
        containerColor = Color.Black,
        topBar = {
            TopAppBar(
                title = { Text("Tasks") },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Add new task */ },
                containerColor = Color(0xFF6B6B6B) // Grey color for FAB
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Task")
            }
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp)
        ) {
            TaskCard(
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun TaskCard(modifier: Modifier = Modifier) {
    val tasks = listOf(
        "task1",
        "task1",
        "task1",
        "task1",
        "task1",
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(text = "My Tasks", color = Color.White)

        LazyColumn(
            modifier = modifier
                .clip(RoundedCornerShape(20.dp))
//                .background(primaryColor),
        ) {
            itemsIndexed(tasks) { index, str ->
                TaskItem(taskName = str)
                if (index != tasks.lastIndex) {
                    HorizontalDivider(color = Color.DarkGray)
                }
            }
        }
    }
}

@Composable
fun TaskItem(taskName: String) {
    Row(
        modifier = Modifier
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            FilledIconToggleButton(
                modifier = Modifier.size(20.dp),
                checked = true,
                onCheckedChange = {},
                content = {}
            )

            Text(
                text = taskName,
                color = Color.White,
            )
        }

//        IconButton(onClick = { /* Star functionality */ }) {
//            Icon(
//                imageVector = Icons.Default.Star,
//                contentDescription = "Star",
//                tint = Color.Gray
//            )
//        }
    }

}

@Preview(showBackground = true)
@Composable
private fun BookmarkPrev() {
    TaskScreen()
}