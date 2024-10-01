package com.example.taskscheduler.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.taskscheduler.ui.theme.primaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppNavBar(
    modifier: Modifier = Modifier,
    route: String
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        windowInsets = WindowInsets(top = 5.dp, bottom = 0.dp),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent
        ),
        title = {
            AnimatedContent(
                targetState = route,
                label = "TopAppBar"
            ) { str ->
                Text(text = str)
            }
        }
    )
}

@Composable
fun ProfileView(
    modifier: Modifier = Modifier,
    user: String,
    onProfileClick: () -> Unit = {}
) {
    Card(
        modifier = modifier,
        shape = CircleShape,
        onClick = onProfileClick
    ) {

    }
}