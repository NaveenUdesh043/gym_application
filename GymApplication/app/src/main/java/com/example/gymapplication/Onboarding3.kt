package com.example.gymapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gymapplication.Activity.MainActivity
import com.example.gymapplication.R

class Onboarding3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboarding3)
        val startBtn: Button = findViewById(R.id.nextBtn)
        startBtn.setOnClickListener{
            val intent = Intent(this, CreateAcoount::class.java)
            startActivity(intent)
        }
    }
}