package com.example.taskscheduler.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.taskscheduler.ui.components.TaskScreenView
import com.example.taskscheduler.utils.Routes

@Composable
fun TaskSearchScreen(
    modifier: Modifier = Modifier,
) {
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
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(40.dp),
                    value = "",
                    onValueChange = {

                    },
                    placeholder = {
                        Text("Tasks, Projects, and More")
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null)
                    }
                )
            }
        },
        onNavItemClick = {

        }
    )
}