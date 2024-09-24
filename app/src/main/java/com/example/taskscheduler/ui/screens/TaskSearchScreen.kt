package com.example.taskscheduler.ui.screens

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.BookmarkAdd
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.taskscheduler.data.Task
import com.example.taskscheduler.ui.components.SearchFilterRow
import com.example.taskscheduler.ui.components.TaskScreenView
import com.example.taskscheduler.ui.theme.primaryColor
import com.example.taskscheduler.ui.theme.secondaryColor
import com.example.taskscheduler.ui.viewmodels.SearchViewModel
import com.example.taskscheduler.utils.Routes
import com.example.taskscheduler.utils.extractTimeFromTimestamp

@Composable
fun TaskSearchScreen(
    modifier: Modifier = Modifier,
    onNavItemClick: (Routes) -> Unit
) {
    val viewModel = hiltViewModel<SearchViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    TaskScreenView(
        modifier = modifier,
        selectedNavItem = Routes.Search,
        view = { pd ->
            Column(
                modifier = modifier
                    .padding(pd)
                    .padding(horizontal = 16.dp)
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(40.dp),
                    value = state.query,
                    onValueChange = viewModel::onSearchQueryChange,
                    placeholder = {
                        Text("Tasks, Projects, and More")
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null)
                    }
                )

                Spacer(modifier = Modifier.height(5.dp))

                PrevSearchesContainer(
                    modifier = Modifier.padding(top = 16.dp),
                    query = state.query
                )
            }
        },
        onNavItemClick = onNavItemClick
    )
}

//@Composable
//fun (modifier: Modifier = Modifier) {
//
//}

@Composable
private fun SearchMatchesContainer(modifier: Modifier = Modifier) {

}

@Composable
fun PrevSearchesContainer(
    modifier: Modifier = Modifier,
    query: String,
//    filter: String
) {
    val tasks = listOf(
        Task(
            title = "Task 1",
            description = "Description 1"
        ),
        Task(
            title = "Task 2",
            description = "Description 2"
        )
    )
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(tasks) {
            TaskListItem(
                modifier = Modifier.fillMaxWidth(),
                task = it
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TaskListItem(
    modifier: Modifier,
    showCategories: Boolean = true,
    task: Task
) {
    var selected by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .clickable {

            }
            .background(secondaryColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            FilledIconToggleButton(
                modifier = Modifier.size(25.dp),
                colors = IconButtonDefaults.filledIconToggleButtonColors(
                    containerColor = if (!selected) Color.White
                    else Color.Black,
                    checkedContainerColor = primaryColor,
                    checkedContentColor = secondaryColor
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

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = task.title,
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    text = task.description!!,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        val tags = listOf(
            "Top",
            "Tasks",
            "Descriptions",
            "Folders",
            "wednesday"
        )

        if (showCategories) {
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                tags.subList(0, 3).forEach {
                    TextButton(
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = primaryColor,
                            contentColor = secondaryColor
                        ),
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            text = it
                        )
                    }
                }
            }
        }
    }
}