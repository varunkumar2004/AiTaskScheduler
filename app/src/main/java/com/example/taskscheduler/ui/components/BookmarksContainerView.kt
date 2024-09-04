package com.example.taskscheduler.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.taskscheduler.data.TaskCategory

@Composable
fun BookmarkContainerView(
    modifier: Modifier = Modifier,
    category: TaskCategory
) {
    var showContainer by remember {
        mutableStateOf(true)
    }

    Card(
        modifier = modifier
    ) {
        Row(
            modifier = modifier
                .padding(start = 16.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = category.title)

            IconButton(onClick = { showContainer = !showContainer }) {
                AnimatedContent(targetState = showContainer) {
                    Icon(
                        imageVector =
                        if (it)
                            Icons.Default.KeyboardArrowUp
                        else Icons.Default.KeyboardArrowDown,
                        contentDescription = null
                    )
                }
            }
        }

        AnimatedVisibility(
            visible = showContainer
        ) {
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth()
            )

            LazyColumn {
                items(category.tasks) { task ->
                    TaskView(
                        modifier = Modifier.fillMaxWidth(),
                        task = task,
                        onTaskViewClick = {

                        }
                    )

                    Spacer(modifier = Modifier.height(2.dp))
                }
            }
        }
    }
}