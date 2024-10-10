package com.example.taskscheduler.data

import kotlinx.serialization.Serializable

interface TaskPriority {
    val priority: Int
}

@Serializable
sealed class Priority(
    override val priority: Int
) : TaskPriority {
    data object HighPriority : Priority(1)
}