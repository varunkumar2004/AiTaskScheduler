package com.example.taskscheduler.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
//import com.example.taskscheduler.ui.theme.secondaryColor
import com.example.taskscheduler.ui.viewmodels.AddTaskState
import com.example.taskscheduler.ui.viewmodels.AddTaskViewModel

@Composable
fun AddTaskScreen(
    modifier: Modifier = Modifier
) {
    val viewModel = hiltViewModel<AddTaskViewModel>()
    val state by viewModel.state.collectAsState()

    val textFieldColors = TextFieldDefaults.colors(
        focusedContainerColor = Color.White,
        unfocusedContainerColor = Color.White,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = "New task",
            style = MaterialTheme.typography.titleLarge
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(30.dp),
            placeholder = {
                Text(text = "title")
            },
            colors = textFieldColors,
            value = state.title,
            onValueChange = viewModel::onTaskTitleChange
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp),
            shape = RoundedCornerShape(30.dp),
            placeholder = {
                Text(text = "description")
            },
            colors = textFieldColors,
            value = state.description ?: "",
            onValueChange = viewModel::onTaskDescriptionChange
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AddTaskPrev() {
    AddTaskScreen(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}