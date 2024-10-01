package com.example.taskscheduler.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskscheduler.ui.theme.primaryColor
import com.example.taskscheduler.ui.theme.secondaryColor
import com.example.taskscheduler.utils.Routes

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    onAddNewTask: () -> Unit,
    onNavItemClick: (Routes) -> Unit
) {
    NavigationBar(
        modifier = modifier
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
        windowInsets = WindowInsets(bottom = 10.dp),
        containerColor = primaryColor,
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            val navButtonColors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = secondaryColor
            )

            Button(
                colors = navButtonColors,
                onClick = { onNavItemClick(Routes.Home) }
            ) {
                Icon(
                    imageVector = Routes.Home.icon!!,
                    contentDescription = Routes.Home.route
                )
            }

            Button(
                colors = navButtonColors,
                onClick = onAddNewTask
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }

            Button(
                colors = navButtonColors,
                onClick = { onNavItemClick(Routes.Search) }
            ) {
                Icon(
                    imageVector = Routes.Search.icon!!,
                    contentDescription = Routes.Search.route
                )
            }

//            Button(
//                colors = navButtonColors,
//                onClick = { onNavItemClick(Routes.Folders) }
//            ) {
//                Icon(
//                    imageVector = Routes.Folders.icon!!,
//                    contentDescription = Routes.Folders.route
//                )
//            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NavBarPrev() {
    BottomNavigationBar(
        modifier = Modifier.fillMaxWidth(),
        onAddNewTask = {},
        onNavItemClick = {}
    )
}