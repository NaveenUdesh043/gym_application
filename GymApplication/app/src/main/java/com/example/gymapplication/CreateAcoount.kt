package com.example.gymapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class CreateAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_acoount)

        val nameEditText: EditText = findViewById(R.id.editTextName)
        val phoneEditText: EditText = findViewById(R.id.editTextPhone)
        val usernameEditText: EditText = findViewById(R.id.editTextUsername)
        val passwordEditText: EditText = findViewById(R.id.editTextPassword)

        val startBtn: Button = findViewById(R.id.nextBtn)

        startBtn.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val phone = phoneEditText.text.toString().trim()
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()


            if (name.isEmpty() || phone.isEmpty() || username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val sharedPref = getSharedPreferences("UserDetails", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("name", name)
            editor.putString("phone", phone)
            editor.putString("username", username)

            editor.putString("password", password)
            editor.apply()


            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
            finish()
        }
    }
}
