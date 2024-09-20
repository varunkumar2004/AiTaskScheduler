package com.example.taskscheduler.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskscheduler.utils.Routes

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    selectedItem: Routes,
    onNavItemClick: (Routes) -> Unit
) {
    NavigationBar(
        modifier = modifier,
    ) {
        NavigationBarItem(
            selected = selectedItem == Routes.Home,
            onClick = { onNavItemClick(Routes.Home) },
            label = {
                Text(text = Routes.Home.route)
            },
            icon = {
                Icon(
                    imageVector = Routes.Home.icon!!,
                    contentDescription = null
                )
            }
        )

        NavigationBarItem(
            selected = selectedItem == Routes.Search,
            onClick = { onNavItemClick(Routes.Search) },
            label = {
                Text(text = Routes.Search.route)
            },
            icon = {
                Icon(
                    imageVector = Routes.Search.icon!!,
                    contentDescription = null
                )
            }
        )

        NavigationBarItem(
            selected = selectedItem == Routes.Bookmarks,
            onClick = { onNavItemClick(Routes.Bookmarks) },
            label = {
                Text(text = Routes.Bookmarks.route)
            },
            icon = {
                Icon(
                    imageVector = Routes.Bookmarks.icon!!,
                    contentDescription = null
                )
            }
        )

        NavigationBarItem(
            selected = selectedItem == Routes.Folders,
            onClick = { onNavItemClick(Routes.Folders) },
            label = {
                Text(text = Routes.Folders.route)
            },
            icon = {
                Icon(
                    imageVector = Routes.Folders.icon!!,
                    contentDescription = null
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NavBarPrev() {
    BottomNavigationBar(
        modifier = Modifier.fillMaxWidth(),
        selectedItem = Routes.Home,
        onNavItemClick = {}
    )
}