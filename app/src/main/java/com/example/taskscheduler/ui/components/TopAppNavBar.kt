package com.example.taskscheduler.ui.components

import android.hardware.lights.Light
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taskscheduler.utils.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppNavBar(
    modifier: Modifier = Modifier,
    route: String
) {
    TopAppBar(
        modifier = modifier
            .padding(end = 10.dp),
        title = {
            AnimatedContent(
                targetState = route,
                label = "top app bar animation"
            ) { str ->
                Text(text = str)
            }
        },
        actions = {
            ProfileView(
                modifier = Modifier
                    .size(35.dp),
                user = "varun"
            )
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