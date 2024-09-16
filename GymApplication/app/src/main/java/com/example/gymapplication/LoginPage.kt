package com.example.gymapplication

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gymapplication.Activity.MainActivity
import com.example.gymapplication.R

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)


        val navigateTextView: TextView = findViewById(R.id.loginTxt)
        navigateTextView.setOnClickListener {
            val intent = Intent(this, ForgotPassword::class.java)
            startActivity(intent)
        }
            val startBtn: Button = findViewById(R.id.nextBtn)
            startBtn.setOnClickListener{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

    }
}