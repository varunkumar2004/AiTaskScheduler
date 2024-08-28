package com.example.taskscheduler.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay

@Composable
fun dynamicGradient(
    primaryColor: Color,
    colors: List<Color>
): Brush {
    var variableColor by remember {
        mutableStateOf(primaryColor)
    }
    val animatedColor by animateColorAsState(
        targetValue = variableColor,
        label = "color gradient animation"
    )

    LaunchedEffect(Unit) {
        while (true) {
            delay(2000)
            variableColor = colors.random()
        }
    }

    return Brush.radialGradient(
        colors = listOf(animatedColor, primaryColor)
    )
}