package com.example.gymapplication.activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.gymapplication.CreateAcoount
import com.example.gymapplication.R
import com.example.gymapplication.LoginPage
import com.example.gymapplication.Onboarding1

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_intro)

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        val startBtn: Button = findViewById(R.id.nextBtn)
        startBtn.setOnClickListener{
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
        }
        val navigateTextView: TextView = findViewById(R.id.signinTxt)
        navigateTextView.setOnClickListener {
            val intent = Intent(this, CreateAcoount::class.java)
            startActivity(intent)
        }
    }
}