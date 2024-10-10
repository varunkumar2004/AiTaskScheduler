package com.example.taskscheduler.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskscheduler.ui.components.TaskView
//import com.example.taskscheduler.ui.theme.primaryColor
//import com.example.taskscheduler.ui.theme.secondaryColor

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TaskScreenView(
    modifier: Modifier = Modifier
) {
    val categories = listOf(
        "String",
        "Task",
        "About",
        "Home"
    )

    LazyColumn(
        modifier = modifier
            .padding(horizontal = 16.dp)
    ) {
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                TaskHeaderView(
                    header = "Title",
                    view = {
                        val textFieldColors = TextFieldDefaults.colors(
//                            focusedContainerColor = secondaryColor,
//                            unfocusedContainerColor = secondaryColor,
//                            focusedIndicatorColor = Color.Transparent,
//                            unfocusedIndicatorColor = Color.Transparent,
//                            cursorColor = primaryColor
                        )

                        Column(
                            verticalArrangement = Arrangement.spacedBy(2.dp)
                        ) {
                            TextField(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(20.dp),
                                value = "",
                                colors = textFieldColors,
                                label = {
                                    Text(text = "title")
                                },
                                onValueChange = {}
                            )

                            TextField(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(20.dp),
                                colors = textFieldColors,
                                label = {
                                    Text(text = "description")
                                },
                                value = "",
                                onValueChange = {}
                            )
                        }
                    }
                )

                TaskHeaderView(
                    header = "Date & Time",
                    view = {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(2.dp)
                        ) {
                            ToggleListItem(
                                modifier = Modifier.fillMaxWidth(),
                                setting = "Date",
                                view = {
                                    val dateState = rememberDatePickerState()

                                    DatePicker(
                                        modifier = Modifier.fillMaxWidth(),
                                        state = dateState,
                                        showModeToggle = false
                                    )
                                }
                            )

                            ToggleListItem(
                                modifier = Modifier.fillMaxWidth(),
                                setting = "Time",
                                view = {
                                    val timeState = rememberTimePickerState()

                                    TimePicker(
                                        modifier = Modifier.fillMaxWidth(),
                                        state = timeState
                                    )
                                }
                            )
                        }
                    }
                )

                TaskHeaderView(
                    header = "Category",
                    view = {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(5.dp)
                        ) {
                            FlowRow(
                                horizontalArrangement = Arrangement.spacedBy(2.dp),
                                verticalArrangement = Arrangement.spacedBy(2.dp)
                            ) {
                                categories.forEach { category ->
                                    Text(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(10.dp))
//                                            .background(secondaryColor)
                                            .padding(10.dp, 5.dp),
                                        text = category,
//                                        color = primaryColor,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }

                                Text(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(10.dp))
//                                        .background(primaryColor)
                                        .clickable {

                                        }
                                        .padding(10.dp, 5.dp),
                                    text = "Add",
//                                    color = secondaryColor,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                )

                TaskHeaderView(
                    header = "Images"
                )
            }
        }
    }
}

@Composable
private fun ToggleListItem(
    modifier: Modifier = Modifier,
    setting: String,
    view: @Composable () -> Unit = {}
) {
    var showContainer by remember {
        mutableStateOf(true)
    }

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
//            .background(secondaryColor)
    ) {
        ListItem(
            modifier = modifier,
            colors = ListItemDefaults.colors(
                containerColor = Color.Transparent,
            ),
            headlineContent = {
                Text(text = setting)
            },
            trailingContent = {
                Switch(
                    colors = SwitchDefaults.colors(
//                        checkedThumbColor = secondaryColor,
//                        checkedTrackColor = primaryColor,
//                        uncheckedBorderColor = primaryColor,
//                        uncheckedThumbColor = primaryColor
                    ),
                    checked = showContainer,
                    onCheckedChange = { showContainer = !showContainer }
                )
            }
        )

        AnimatedVisibility(visible = showContainer) {
            HorizontalDivider(modifier = modifier)
            Spacer(modifier = Modifier.height(16.dp))
            view()
        }
    }
}

@Composable
private fun TaskHeaderView(
    modifier: Modifier = Modifier,
    header: String,
    view: @Composable () -> Unit = {}
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(
            text = header,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )

        view()
    }
}

@Preview(showBackground = true)
@Composable
private fun TaskAddPrev() {
    TaskScreenView(
        modifier = Modifier.fillMaxWidth()
    )
}