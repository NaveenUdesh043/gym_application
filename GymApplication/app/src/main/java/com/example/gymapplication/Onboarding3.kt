package com.example.gymapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

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