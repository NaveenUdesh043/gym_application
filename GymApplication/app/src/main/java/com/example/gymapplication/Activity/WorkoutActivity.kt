package com.example.gymapplication.Activity

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.gymapplication.Adapter.LessonsAdapter
import com.example.gymapplication.Domain.Workout
import com.example.gymapplication.databinding.ActivityWorkoutBinding

class WorkoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWorkoutBinding
    private var workout: Workout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using ViewBinding
        binding = ActivityWorkoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Enable edge-to-edge layout
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        // Retrieve the workout object and set the variables
        getObject()
        setVariable()
    }

    // Method to retrieve the passed Workout object from the intent
    private fun getObject() {
        workout = intent.getSerializableExtra("object") as? Workout
    }

    // Method to set the variables and update UI
    private fun setVariable() {
        workout?.let { workout ->
            val resId = resources.getIdentifier(workout.picPath, "drawable", packageName)
            Glide.with(this)
                .load(resId)
                .into(binding.pic2)

            // Set OnClickListener for back button
            binding.backBtn.setOnClickListener {
                finish()
            }

            // Set workout details in the UI components
            binding.titleTxt.text = workout.title
            binding.exerciseTxt.text = "${workout.lessons.size} Exercises"
            binding.kcalTxt.text = "${workout.kcal} Kcal"
            binding.durationTxt.text = workout.durationAll
            binding.descriptionTxt.text = workout.description

            // Set up RecyclerView for lessons
            binding.view3.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.view3.adapter = LessonsAdapter(workout.lessons)
        }
    }
}
