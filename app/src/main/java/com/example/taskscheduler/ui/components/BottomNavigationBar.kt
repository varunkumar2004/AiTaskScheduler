package com.example.taskscheduler.ui.components

import android.media.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.taskscheduler.utils.Routes

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    selectedItem: Routes,
    onNavItemClick: (Routes) -> Unit
) {
    BottomAppBar(
        containerColor = Color.Transparent,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val buttonModifier = Modifier
                    .height(TextFieldDefaults.MinHeight)

                NavItemChip(
                    modifier = buttonModifier,
                    isSelected = selectedItem == Routes.Home,
                    onNavItemChipClick = { onNavItemClick(Routes.Home) },
                    icon = Routes.Home.icon!!,
                    label = Routes.Home.route
                )

                NavItemChip(
                    modifier = buttonModifier,
                    isSelected = selectedItem == Routes.Bookmarks,
                    onNavItemChipClick = { onNavItemClick(Routes.Bookmarks) },
                    label = Routes.Bookmarks.route
                )

                NavItemChip(
                    modifier = buttonModifier,
                    isSelected = selectedItem == Routes.Folders,
                    onNavItemChipClick = { onNavItemClick(Routes.Folders) },
                    label = Routes.Folders.route
                )
            }

            IconButton(
                colors = IconButtonDefaults.filledIconButtonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.Black
                ),
                onClick = {

                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add task"
                )
            }
        }
    }
}

@Composable
private fun NavItemChip(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    onNavItemChipClick: () -> Unit,
    icon: ImageVector? = null,
    label: String
) {
    TextButton(
        modifier = modifier,
        onClick = onNavItemChipClick,
        colors = ButtonDefaults.textButtonColors(
            containerColor = if (isSelected) Color.LightGray else Color.Transparent,
        )
    ) {
        Text(
            text = label,
            modifier = Modifier
                .padding(horizontal = 10.dp)
        )
    }
}