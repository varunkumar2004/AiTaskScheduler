package com.example.taskscheduler.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.taskscheduler.data.Task

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TaskListItem(
    modifier: Modifier,
    showCategories: Boolean = false,
    task: Task,
    onClick: () -> Unit = {}
) {
    var selected by remember {
        mutableStateOf(false)
    }

    val tags = listOf(
        "Top",
        "Tasks",
        "Descriptions",
        "Folders",
        "wednesday"
    )

//    Column(
//        modifier = modifier
//            .clip(RoundedCornerShape(30.dp))
//            .clickable { onClick() }
//            .background(secondaryColor)
//            .padding(horizontal = 16.dp)
//            .padding(top = 16.dp, bottom = 5.dp),
////        verticalArrangement = Arrangement.spacedBy(5.dp)
//    ) {
//        Row(
//            modifier = modifier,
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.spacedBy(10.dp)
//        ) {
//            FilledIconToggleButton(
//                modifier = Modifier.size(25.dp),
//                colors = IconButtonDefaults.filledIconToggleButtonColors(
//                    containerColor = if (!selected) Color.White
//                    else Color.Black,
//                    checkedContainerColor = primaryColor,
//                    checkedContentColor = secondaryColor
//                ),
//                checked = selected,
//                onCheckedChange = { selected = !selected }
//            ) {
//                Icon(
//                    modifier = Modifier.size(10.dp),
//                    imageVector = Icons.Default.Done,
//                    contentDescription = null
//                )
//            }
//
//            Column(
//                modifier = Modifier.weight(1f),
//                verticalArrangement = Arrangement.spacedBy(2.dp)
//            ) {
//                Text(
//                    text = task.title,
//                    maxLines = 1,
//                    fontWeight = FontWeight.Bold,
//                    style = MaterialTheme.typography.bodyLarge
//                )
//
//                Text(
//                    text = task.description!!,
//                    maxLines = 2,
//                    overflow = TextOverflow.Ellipsis,
//                    style = MaterialTheme.typography.bodyMedium
//                )
//            }
//        }
//
//
//
//        if (showCategories) {
//            LazyRow(
//                horizontalArrangement = Arrangement.spacedBy(5.dp)
//            ) {
//                items(tags.shuffled().take(3)) {
//                    TextButton(onClick = { /*TODO*/ }) {
//                        Text(
//                            text = "#$it",
//                            fontWeight = FontWeight.Bold,
//                            color = primaryColor
//                        )
//                    }
//                }
//            }
//        }
//    }

    val listItemColors = ListItemDefaults.colors(
        containerColor = Color.Transparent
    )

    ListItem(
        modifier = modifier
            .clickable { onClick() },
        colors = listItemColors,
        headlineContent = {
            Text(
                text = task.title,
                maxLines = 1,
                fontWeight = FontWeight.Bold,
//                color = primaryColor,
                style = MaterialTheme.typography.bodyLarge
            )
        },
        supportingContent = {
            Column(
                modifier = modifier,
            ) {
                task.description?.let { str ->
                    Text(
                        text = str,
                        maxLines = 2,
//                        color = primaryColor.copy(alpha = 0.8f),
                        overflow = TextOverflow.Ellipsis
                    )
                }

                if (!showCategories) {
                    SuggestionChip(
                        onClick = { /*TODO*/ },
                        label = {
                            Text(
                                text = "Task",
                                fontWeight = FontWeight.SemiBold,
                            )
                        }
                    )
                }
            }
        },
        leadingContent = {
            FilledIconToggleButton(
                modifier = Modifier.size(25.dp),
                colors = IconButtonDefaults.filledIconToggleButtonColors(
//                    containerColor = if (!selected) Color.White
//                    else Color.Black,
//                    checkedContainerColor = primaryColor,
//                    checkedContentColor = secondaryColor
                ),
                checked = selected,
                onCheckedChange = { selected = !selected }
            ) {
                Icon(
                    modifier = Modifier.size(10.dp),
                    imageVector = Icons.Default.Done,
                    contentDescription = null
                )
            }
        }
    )
}