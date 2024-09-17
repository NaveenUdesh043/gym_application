package com.example.gymapplication.activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gymapplication.adapter.WorkoutAdapter
import com.example.gymapplication.domain.Lesson
import com.example.gymapplication.domain.Workout
import com.example.gymapplication.ProfilePage
import com.example.gymapplication.R
import com.example.gymapplication.ToDoPage
import com.example.gymapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val profileImageView = findViewById<ImageView>(R.id.profilePage)
        profileImageView.setOnClickListener {
            val intent = Intent(this, ProfilePage::class.java)
            startActivity(intent)
        }


        val favImageView = findViewById<ImageView>(R.id.todoBtn)
        favImageView.setOnClickListener {
            val intent = Intent(this, ToDoPage::class.java)
            startActivity(intent)
        }



        binding.view1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.view1.adapter = WorkoutAdapter(getData())
    }

    private fun getData(): ArrayList<Workout> {
        val list = ArrayList<Workout>()

        list.add(Workout("Running", "You just woke up. It is a brand new day. The canvas is blank. How do you begin? Take 21 minutes to cultivate a peaceful mind and strong body.", "pic_1", 160, "9 min", getLesson1()))
        list.add(Workout("Stretching", "You just woke up. It is a brand new day. The canvas is blank. How do you begin? Take 21 minutes to cultivate a peaceful mind and strong body.", "pic_2", 230, "85 min", getLesson2()))
        list.add(Workout("Yoga", "You just woke up. It is a brand new day. The canvas is blank. How do you begin? Take 21 minutes to cultivate a peaceful mind and strong body.", "pic_3", 180, "65 min", getLesson3()))

        return list
    }

    private fun getLesson1(): ArrayList<Lesson> {
        val list = ArrayList<Lesson>()

        list.add(Lesson("Lesson 1", "00:53", "HBPbYFkMpE_1", "pic_1_1"))
        list.add(Lesson("Lesson 2", "01:21", "K6lZ4Wg1lp_2", "pic_1_2"))
        list.add(Lesson("Lesson 3", "01:57", "ZcO8v4YVOaE_3", "pic_1_3"))

        return list
    }

    private fun getLesson2(): ArrayList<Lesson> {
        val list = ArrayList<Lesson>()

        list.add(Lesson("Lesson 1", "20:23", "JeImBAX7TjF_1", "pic_3_1"))
        list.add(Lesson("Lesson 2", "32:06", "XZegzOTF_2", "pic_3_2"))
        list.add(Lesson("Lesson 3", "45:22", "OnLx8aTWGg_3", "pic_3_3"))
        list.add(Lesson("Lesson 4", "07:52", "w86EaLEoFrY_4", "pic_3_4"))

        return list
    }

    private fun getLesson3(): ArrayList<Lesson> {
        val list = ArrayList<Lesson>()

        list.add(Lesson("Lesson 1", "23:00", "v7AYKMP6rOE", "pic_3_1"))
        list.add(Lesson("Lesson 2", "27:00", "Eml2xnoLpYE", "pic_3_2"))
        list.add(Lesson("Lesson 3", "25:00", "v7SN-d4qXx0", "pic_3_3"))
        list.add(Lesson("Lesson 4", "21:00", "LqXZ628YNj4", "pic_3_4"))

        return list
    }
}
