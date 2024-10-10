package com.example.taskscheduler.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.taskscheduler.data.Task
import com.example.taskscheduler.ui.components.TaskListItem
import com.example.taskscheduler.ui.components.TaskView
//import com.example.taskscheduler.ui.theme.primaryColor
//import com.example.taskscheduler.ui.theme.secondaryColor
import com.example.taskscheduler.ui.viewmodels.SearchState
import com.example.taskscheduler.ui.viewmodels.SearchViewModel
import com.example.taskscheduler.utils.Routes

@Composable
fun TaskSearchScreen(
    modifier: Modifier = Modifier,
    onNavItemClick: (Routes) -> Unit
) {
    val viewModel = hiltViewModel<SearchViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    val categories = listOf(
        "Personal",
        "Work",
        "Family",
        "School",
        "Other"
    )



    TaskView(
        modifier = modifier,
//        selectedNavItem = Routes.Search,
        view = { pd ->
            Column(
                modifier = modifier
                    .padding(pd)
            ) {
                val pdModifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)

                SearchTextField(
                    modifier = pdModifier,
                    state = state,
                    onSearchQueryChange = viewModel::onSearchQueryChange
                )

                SearchFilterChips(
                    modifier = Modifier.fillMaxWidth(),
                    categories = categories
                )

                PrevSearchesContainer(
                    modifier = pdModifier,
                    query = state.query
                )
            }
        },
        onNavItemClick = onNavItemClick
    )
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
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(tasks) {
            TaskListItem(
                modifier = Modifier.fillMaxWidth(),
                task = it,
                showCategories = false
            )
        }
    }
}

@Composable
private fun SearchTextField(
    modifier: Modifier = Modifier,
    state: SearchState,
    onSearchQueryChange: (String) -> Unit,
) {
    val colors = TextFieldDefaults.colors(
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
//        focusedIndicatorColor = primaryColor,
//        unfocusedIndicatorColor = primaryColor,
//        disabledIndicatorColor = primaryColor,
//        cursorColor = primaryColor
    )

    OutlinedTextField(
        modifier = modifier,
        colors = colors,
        shape = RoundedCornerShape(40.dp),
        value = state.query,
        onValueChange = onSearchQueryChange,
        placeholder = {
            Text("Tasks, Projects, and More")
        }
    )
}

@Composable
private fun SearchFilterChips(
    modifier: Modifier = Modifier,
    categories: List<String>
) {
    val colors = FilterChipDefaults.filterChipColors(
//        selectedContainerColor = primaryColor,
//        containerColor = primaryColor,
//        labelColor = secondaryColor,
//        disabledLabelColor = secondaryColor,
//        selectedLabelColor = secondaryColor
    )

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        item {
            Spacer(modifier = Modifier.width(16.dp))
        }

        items(categories) { category ->
            FilterChip(
                shape = RoundedCornerShape(40.dp),
                selected = true,
                colors = colors,
                onClick = { /*TODO*/ },
                label = {
                    Text(
                        text = category
                    )
                }
            )
        }
    }
}
