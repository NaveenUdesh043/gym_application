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
import com.example.gymapplication.domain.Task
import java.util.*

class ToDoPage : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var workoutNameInput: EditText
    private lateinit var workoutDurationInput: EditText
    private lateinit var addWorkoutButton: Button
    private lateinit var deleteWorkoutButton: Button
    private lateinit var workoutListView: ListView
    private lateinit var workoutTimePicker: TimePicker
    private val workoutList = mutableListOf<Task>()
    private lateinit var workoutAdapter: TaskAdapter
    private var selectedWorkoutIndex: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        sharedPreferences = getSharedPreferences("workouts_prefs", Context.MODE_PRIVATE)
        workoutNameInput = findViewById(R.id.workout_name_input)
        workoutDurationInput = findViewById(R.id.workout_duration_input)
        addWorkoutButton = findViewById(R.id.add_workout_button)
        deleteWorkoutButton = findViewById(R.id.delete_workout_button)
        workoutListView = findViewById(R.id.workout_list)
        workoutTimePicker = findViewById(R.id.workout_time_picker)

        workoutAdapter = TaskAdapter(this, workoutList)
        workoutListView.adapter = workoutAdapter

        addWorkoutButton.setOnClickListener {
            addWorkout()
        }

        deleteWorkoutButton.setOnClickListener {
            deleteWorkout()
        }

        workoutListView.setOnItemClickListener { _, _, position, _ ->
            selectedWorkoutIndex = position
            workoutNameInput.setText(workoutList[position].description)
        }

        loadWorkouts()
        startNotificationService()
    }

    private fun addWorkout() {
        val workoutName = workoutNameInput.text.toString()
        val workoutDuration = workoutDurationInput.text.toString()
        val workoutDateTime = Calendar.getInstance().timeInMillis

        val reminderCalendar = Calendar.getInstance()
        reminderCalendar.set(Calendar.HOUR_OF_DAY, workoutTimePicker.hour)
        reminderCalendar.set(Calendar.MINUTE, workoutTimePicker.minute)
        reminderCalendar.set(Calendar.SECOND, 0)
        val reminderTime = reminderCalendar.timeInMillis

        if (workoutName.isNotEmpty() && workoutDuration.isNotEmpty()) {
            if (selectedWorkoutIndex != null) {
                val workout = workoutList[selectedWorkoutIndex!!]
                workout.description = workoutName
                workout.duration = workoutDuration
                workout.dateTime = workoutDateTime
                workout.reminderTime = reminderTime
                selectedWorkoutIndex = null
            } else {
                val workout = Task(workoutName, workoutDateTime, reminderTime, workoutDuration)
                workoutList.add(workout)
            }
            saveWorkouts()
            updateWorkoutAdapter()
            workoutNameInput.text.clear()
            workoutDurationInput.text.clear()
        }
    }


    private fun deleteWorkout() {
        selectedWorkoutIndex?.let { index ->
            workoutList.removeAt(index)
            selectedWorkoutIndex = null
            saveWorkouts()
            updateWorkoutAdapter()
            workoutNameInput.text.clear()
            workoutDurationInput.text.clear()
        }
    }

    private fun saveWorkouts() {
        val editor = sharedPreferences.edit()
        editor.clear()
        for ((index, workout) in workoutList.withIndex()) {
            editor.putString("workout_$index", "${workout.description}|${workout.dateTime}|${workout.reminderTime}|${workout.duration}")
        }
        editor.putInt("workout_count", workoutList.size)
        editor.apply()
    }

    private fun loadWorkouts() {
        val count = sharedPreferences.getInt("workout_count", 0)
        workoutList.clear()
        for (i in 0 until count) {
            val workoutString = sharedPreferences.getString("workout_$i", null) ?: continue
            val (description, dateTime, reminderTime, duration) = workoutString.split("|")
            workoutList.add(Task(description, dateTime.toLong(), reminderTime.toLong(), duration)) // Add duration
        }
        updateWorkoutAdapter()
    }


    private fun updateWorkoutAdapter() {
        workoutAdapter.notifyDataSetChanged()
    }

    private fun startNotificationService() {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(object : Runnable {
            override fun run() {
                checkWorkoutsDue()
                handler.postDelayed(this, 60000)
            }
        }, 0)
    }

    private fun checkWorkoutsDue() {
        val currentTime = Calendar.getInstance().timeInMillis
        for (workout in workoutList) {
            if (workout.dateTime <= currentTime) {
                sendNotification(workout, "Workout Due", "Workout: ${workout.description}")
                workoutList.remove(workout)
                saveWorkouts()
                updateWorkoutAdapter()
                break
            } else if (workout.reminderTime <= currentTime) {
                sendNotification(workout, "Workout Reminder", "Reminder: ${workout.description}")
                break
            }
        }
    }

    private fun sendNotification(workout: Task, title: String, message: String) {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "workout_channel"
        val channel = NotificationChannel(channelId, "Workout Notifications", NotificationManager.IMPORTANCE_DEFAULT)
        notificationManager.createNotificationChannel(channel)

        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        notificationManager.notify(1, notification)
    }

    inner class TaskAdapter(context: Context, private val tasks: List<Task>) : ArrayAdapter<Task>(context, R.layout.activity_task_list_time, tasks) {
        override fun getView(position: Int, convertView: android.view.View?, parent: android.view.ViewGroup): android.view.View {
            val view = convertView ?: layoutInflater.inflate(R.layout.activity_task_list_time, parent, false)
            val task = tasks[position]

            val descriptionTextView: TextView = view.findViewById(R.id.task_description)
            val dateTimeTextView: TextView = view.findViewById(R.id.task_datetime)
            val reminderTimeTextView: TextView = view.findViewById(R.id.task_reminder_time)
            val durationTextView: TextView = view.findViewById(R.id.task_duration)

            descriptionTextView.text = task.description
            dateTimeTextView.text = task.getFormattedDateTime()
            reminderTimeTextView.text = task.getFormattedReminderTime()
            durationTextView.text = "Duration: ${task.duration} mins"

            return view
        }
    }

}
