package com.example.gymapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gymapplication.R

class ProfilePage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile_page)


        val startBtn: Button = findViewById(R.id.nextBtn)
        startBtn.setOnClickListener {

            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
        }
    }
}
