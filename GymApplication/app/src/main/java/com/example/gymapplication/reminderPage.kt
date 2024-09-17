package com.example.gymapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

//class ReminderBroadcastReceiver : BroadcastReceiver() {
//    override fun onReceive(context: Context, intent: Intent) {
//        val taskDescription = intent.getStringExtra("task_description") ?: return
//
//        val notification = NotificationCompat.Builder(context, "task_channel")
//            .setContentTitle("Task Reminder")
//            .setContentText("Reminder: $taskDescription")
//            .setSmallIcon(android.R.drawable.ic_dialog_info)
//            .setPriority(NotificationCompat.PRIORITY_HIGH)
//            .build()
//
//        val notificationManager = NotificationManagerCompat.from(context)
//        notificationManager.notify(taskDescription.hashCode(), notification)
//    }
//}
