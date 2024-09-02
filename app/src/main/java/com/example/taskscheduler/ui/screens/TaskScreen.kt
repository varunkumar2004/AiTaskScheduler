package com.example.taskscheduler.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(
    modifier: Modifier = Modifier
) {
    val fModifier = Modifier.fillMaxWidth()
    var selectedItem by remember { mutableIntStateOf(0) }
    var queryValue by remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    TextField(
                        modifier = fModifier
                            .padding(end = 16.dp),
                        shape = RoundedCornerShape(40.dp),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        placeholder = {
                            Text(text = "Search")
                        },
                        trailingIcon = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "search"
                                )
                            }
                        },
                        value = queryValue,
                        onValueChange = {
                            queryValue = it
                        }
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = fModifier
                .padding(16.dp)
                .padding(innerPadding)
        ) {
            IconTextCol(
                modifier = fModifier,
                icon = Icons.Default.Home,
                text = "Home",
                isSelected = selectedItem == 0,
                onClickAction = {
                    selectedItem = 0
                }
            )

            IconTextCol(
                modifier = fModifier,
                icon = Icons.Outlined.Bookmark,
                text = "Bookmark",
                isSelected = selectedItem == 1,
                onClickAction = {
                    selectedItem = 1
                }
            )

            IconTextCol(
                modifier = fModifier,
                icon = Icons.Default.Folder,
                text = "Folders",
                isSelected = selectedItem == 2,
                onClickAction = {
                    selectedItem = 2
                }
            )
        }
    }
}

@Composable
private fun IconTextCol(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    icon: ImageVector,
    text: String,
    onClickAction: () -> Unit
) {
    Card(
        modifier = modifier,
        onClick = onClickAction,
        shape = RoundedCornerShape(40.dp),
        colors = CardDefaults.cardColors(
            containerColor =
            if (isSelected) MaterialTheme.colorScheme.surfaceContainer
            else Color.Transparent
        )
    ) {
        Row(
            modifier = modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text
            )

            Text(text = text)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TaskPrev() {
    TaskScreen(
        modifier = Modifier.fillMaxWidth()
    )
}