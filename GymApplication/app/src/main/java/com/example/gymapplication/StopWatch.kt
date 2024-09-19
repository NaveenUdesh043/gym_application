package com.example.gymapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StopWatch : AppCompatActivity() {

    private lateinit var stopwatchDisplay: TextView
    private lateinit var startButton: Button
    private lateinit var pauseButton: Button
    private lateinit var resetButton: Button
    private var isRunning = false
    private var elapsedTime: Long = 0
    private val handler = Handler(Looper.getMainLooper())
    private lateinit var runnable: Runnable

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatch)


        stopwatchDisplay = findViewById(R.id.stopwatchDisplay)
        startButton = findViewById(R.id.startButton)
        pauseButton = findViewById(R.id.pauseButton)
        resetButton = findViewById(R.id.resetButton)

        runnable = object : Runnable {
            override fun run() {
                elapsedTime++
                stopwatchDisplay.text = formatTime(elapsedTime)
                handler.postDelayed(this, 1000)
            }
        }


        startButton.setOnClickListener {
            startStopwatch()
        }

        pauseButton.setOnClickListener {
            pauseStopwatch()
        }

        resetButton.setOnClickListener {
            resetStopwatch()
        }
    }

    private fun startStopwatch() {
        if (!isRunning) {
            isRunning = true
            handler.post(runnable)
            startButton.visibility = android.view.View.GONE
            pauseButton.visibility = android.view.View.VISIBLE
            resetButton.visibility = android.view.View.VISIBLE
        }
    }

    private fun pauseStopwatch() {
        if (isRunning) {
            isRunning = false
            handler.removeCallbacks(runnable)
            startButton.visibility = android.view.View.VISIBLE
            startButton.text = "Resume"
            pauseButton.visibility = android.view.View.GONE
        }
    }

    private fun resetStopwatch() {
        isRunning = false
        handler.removeCallbacks(runnable)
        elapsedTime = 0
        stopwatchDisplay.text = formatTime(elapsedTime)
        startButton.visibility = android.view.View.VISIBLE
        startButton.text = "Start"
        pauseButton.visibility = android.view.View.GONE
        resetButton.visibility = android.view.View.GONE
    }

    private fun formatTime(seconds: Long): String {
        val hours = seconds / 3600
        val minutes = (seconds % 3600) / 60
        val secs = seconds % 60
        return String.format("%02d:%02d:%02d", hours, minutes, secs)
    }
}
