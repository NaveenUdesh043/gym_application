package com.example.gymapplication.Domain

import java.text.SimpleDateFormat
import java.util.*

data class Task(
    var description: String,
    var dateTime: Long,
    var reminderTime: Long
) {
    fun getFormattedDateTime(): String {
        val date = Date(dateTime)
        val format = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
        return format.format(date)
    }

    fun getFormattedReminderTime(): String {
        val date = Date(reminderTime)
        val format = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
        return format.format(date)
    }
}
