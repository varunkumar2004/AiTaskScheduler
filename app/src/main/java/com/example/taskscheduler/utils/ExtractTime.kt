package com.example.taskscheduler.utils

import java.sql.Date
import java.text.SimpleDateFormat
import java.util.Locale

fun extractTimeFromTimestamp(timestamp: Long) : String {
    val date = Date(timestamp)
    val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return format.format(date)
}