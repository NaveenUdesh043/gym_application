package com.example.gymapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.example.gymapplication.Domain.Task
import java.util.*

class ToDoPage : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var taskInput: EditText
    private lateinit var addTaskButton: Button
    private lateinit var deleteTaskButton: Button
    private lateinit var taskListView: ListView
    private lateinit var reminderTimePicker: TimePicker
    private val taskList = mutableListOf<Task>()
    private lateinit var taskAdapter: TaskAdapter
    private var selectedTaskIndex: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        sharedPreferences = getSharedPreferences("tasks_prefs", Context.MODE_PRIVATE)
        taskInput = findViewById(R.id.task_input)
        addTaskButton = findViewById(R.id.add_task_button)
        deleteTaskButton = findViewById(R.id.delete_task_button)
        taskListView = findViewById(R.id.task_list)
        reminderTimePicker = findViewById(R.id.reminder_time_picker)

        taskAdapter = TaskAdapter(this, taskList)
        taskListView.adapter = taskAdapter

        addTaskButton.setOnClickListener {
            addTask()
        }

        deleteTaskButton.setOnClickListener {
            deleteTask()
        }

        taskListView.setOnItemClickListener { _, _, position, _ ->
            selectedTaskIndex = position
            taskInput.setText(taskList[position].description)
        }

        loadTasks()
        startNotificationService()
    }

    private fun addTask() {
        val taskDescription = taskInput.text.toString()
        val taskDateTime = Calendar.getInstance().timeInMillis

        // Get reminder time from TimePicker
        val reminderCalendar = Calendar.getInstance()
        reminderCalendar.set(Calendar.HOUR_OF_DAY, reminderTimePicker.hour)
        reminderCalendar.set(Calendar.MINUTE, reminderTimePicker.minute)
        reminderCalendar.set(Calendar.SECOND, 0)
        val reminderTime = reminderCalendar.timeInMillis

        if (taskDescription.isNotEmpty()) {
            if (selectedTaskIndex != null) {
                // Update existing task
                val task = taskList[selectedTaskIndex!!]
                task.description = taskDescription
                task.dateTime = taskDateTime
                task.reminderTime = reminderTime
                selectedTaskIndex = null
            } else {
                // Add new task
                val task = Task(taskDescription, taskDateTime, reminderTime)
                taskList.add(task)
            }
            saveTasks()
            updateTaskAdapter()
            taskInput.text.clear()
        }
    }

    private fun deleteTask() {
        selectedTaskIndex?.let { index ->
            taskList.removeAt(index)
            selectedTaskIndex = null
            saveTasks()
            updateTaskAdapter()
            taskInput.text.clear()
        }
    }

    private fun saveTasks() {
        val editor = sharedPreferences.edit()
        editor.clear()
        for ((index, task) in taskList.withIndex()) {
            editor.putString("task_$index", "${task.description}|${task.dateTime}|${task.reminderTime}")
        }
        editor.putInt("task_count", taskList.size)
        editor.apply()
    }

    private fun loadTasks() {
        val count = sharedPreferences.getInt("task_count", 0)
        taskList.clear() // Clear current list to avoid duplication
        for (i in 0 until count) {
            val taskString = sharedPreferences.getString("task_$i", null) ?: continue
            val (description, dateTime, reminderTime) = taskString.split("|")
            taskList.add(Task(description, dateTime.toLong(), reminderTime.toLong()))
        }
        updateTaskAdapter()
    }

    private fun updateTaskAdapter() {
        taskAdapter.notifyDataSetChanged()
    }

    private fun startNotificationService() {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(object : Runnable {
            override fun run() {
                checkTasksDue()
                handler.postDelayed(this, 60000) // Check every minute
            }
        }, 0)
    }

    private fun checkTasksDue() {
        val currentTime = Calendar.getInstance().timeInMillis
        for (task in taskList) {
            if (task.dateTime <= currentTime) {
                sendNotification(task, "Task Due", "Task: ${task.description}")
                taskList.remove(task)
                saveTasks()
                updateTaskAdapter()
                break
            } else if (task.reminderTime <= currentTime) {
                sendNotification(task, "Task Reminder", "Reminder: ${task.description}")
                // Optionally, remove the reminder but keep the task in the list
                // taskList.remove(task)
                // saveTasks()
                // updateTaskAdapter()
                break
            }
        }
    }

    private fun sendNotification(task: Task, title: String, message: String) {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "task_channel"
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, "Task Notifications", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        notificationManager.notify(1, notification)
    }

    // Custom ArrayAdapter for tasks
    inner class TaskAdapter(context: Context, private val tasks: List<Task>) : ArrayAdapter<Task>(context, R.layout.activity_task_list_time, tasks) {
        override fun getView(position: Int, convertView: android.view.View?, parent: android.view.ViewGroup): android.view.View {
            val view = convertView ?: layoutInflater.inflate(R.layout.activity_task_list_time, parent, false)
            val task = tasks[position]

            val descriptionTextView: TextView = view.findViewById(R.id.task_description)
            val dateTimeTextView: TextView = view.findViewById(R.id.task_datetime)
            val reminderTimeTextView: TextView = view.findViewById(R.id.task_reminder_time)

            descriptionTextView.text = task.description
            dateTimeTextView.text = task.getFormattedDateTime()
            reminderTimeTextView.text = task.getFormattedReminderTime()

            return view
        }
    }
}
