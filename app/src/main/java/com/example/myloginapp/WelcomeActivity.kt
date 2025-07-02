package com.example.myloginapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val tvWelcomeMessage = findViewById<TextView>(R.id.tvWelcomeMessage)

        // Get the username from the Intent
        val username = intent.getStringExtra("USERNAME")

        tvWelcomeMessage.text=getString(R.string.welcome_message,username)
    }
}