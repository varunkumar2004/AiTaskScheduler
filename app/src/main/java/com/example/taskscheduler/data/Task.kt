package com.example.taskscheduler.data

data class Task (
    val title: String,
    val description: String? = null,
    val isCompleted: Boolean = false,
    val priority: Priority = Priority.HighPriority,
    val timeStamp: Long = System.currentTimeMillis(),
)