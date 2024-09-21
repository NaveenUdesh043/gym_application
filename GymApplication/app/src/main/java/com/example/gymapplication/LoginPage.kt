package com.example.gymapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.gymapplication.activity.MainActivity

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)



        val usernameEditText: EditText = findViewById(R.id.editTextUsername)
        val passwordEditText: EditText = findViewById(R.id.editTextPassword)

        val startBtn: Button = findViewById(R.id.nextBtn)

        val navigateTextView: TextView = findViewById(R.id.loginTxt)
        navigateTextView.setOnClickListener {
            val intent = Intent(this, ForgotPassword::class.java)
            startActivity(intent)
        }
        val navigateTextView1: TextView = findViewById(R.id.signinTxt)
        navigateTextView1.setOnClickListener {
            val intent = Intent(this, CreateAccount::class.java)
            startActivity(intent)
        }


        startBtn.setOnClickListener {
            val enteredUsername = usernameEditText.text.toString()
            val enteredPassword = passwordEditText.text.toString()


            if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
                Toast.makeText(this, "Please fill in both fields!", Toast.LENGTH_SHORT).show()
            } else {
                val sharedPref = getSharedPreferences("UserDetails", Context.MODE_PRIVATE)
                val savedUsername = sharedPref.getString("username", null)
                val savedPassword = sharedPref.getString("password", null)

                if (enteredUsername == savedUsername && enteredPassword == savedPassword) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Invalid username or password!", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}
