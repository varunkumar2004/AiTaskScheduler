package com.example.taskscheduler.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.taskscheduler.utils.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppNavBar(
    modifier: Modifier = Modifier,
    route: String
) {
    AnimatedContent(
        targetState = route,
        label = "top app bar animation"
    ) {str ->
        TopAppBar(
            modifier = modifier,
            title = {
                Text(text = str)
            }
        )
    }
}