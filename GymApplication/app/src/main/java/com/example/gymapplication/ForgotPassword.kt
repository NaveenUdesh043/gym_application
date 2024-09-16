package com.example.gymapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gymapplication.R
import com.example.gymapplication.LoginPage

class ForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forgot_password)

        val startBtn: Button = findViewById(R.id.nextBtn1)
        startBtn.setOnClickListener{
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
        }

        val newPasswordField: EditText = findViewById(R.id.editTextUsername)
        val confirmPasswordField: EditText = findViewById(R.id.editTextPassword)

        val nextButton: Button = findViewById(R.id.nextBtn)

        nextButton.setOnClickListener {

            val newPassword = newPasswordField.text.toString()
            val confirmPassword = confirmPasswordField.text.toString()

            if (newPassword == confirmPassword) {

                Toast.makeText(this, "Passwords match!", Toast.LENGTH_SHORT).show()

            } else {

                Toast.makeText(this, "Passwords do not match! Please try again.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
