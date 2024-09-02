package com.example.taskscheduler.data

interface TaskPriority {
    val priority: Int
}

sealed class Priority(
    override val priority: Int
) : TaskPriority {
    data object HighPriority : Priority(1)
}