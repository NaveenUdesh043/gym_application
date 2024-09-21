package com.example.gymapplication.activity

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.gymapplication.adapter.LessonsAdapter
import com.example.gymapplication.domain.Workout
import com.example.gymapplication.databinding.ActivityWorkoutBinding

class WorkoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWorkoutBinding
    private var workout: Workout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityWorkoutBinding.inflate(layoutInflater)
        setContentView(binding.root)


        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        getObject()
        setVariable()
    }


    private fun getObject() {
        workout = intent.getSerializableExtra("object") as? Workout
    }


    private fun setVariable() {
        workout?.let { workout ->
            val resId = resources.getIdentifier(workout.picPath, "drawable", packageName)
            Glide.with(this)
                .load(resId)
                .into(binding.pic2)


            binding.backBtn.setOnClickListener {
                finish()
            }


            binding.titleTxt.text = workout.title
            binding.exerciseTxt.text = "${workout.lessons.size} Exercises"
            binding.kcalTxt.text = "${workout.kcal} Kcal"
            binding.durationTxt.text = workout.durationAll
            binding.descriptionTxt.text = workout.description


            binding.view3.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.view3.adapter = LessonsAdapter(workout.lessons)
        }
    }
}
