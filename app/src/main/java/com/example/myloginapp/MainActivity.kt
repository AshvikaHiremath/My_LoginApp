package com.example.myloginapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.autofill.AutofillManager
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // Enable Autofill only if the API level is 26 (Android 8.0) or higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val autofillManager = getSystemService(AutofillManager::class.java)
            autofillManager?.requestAutofill(etUsername)
            autofillManager?.requestAutofill(etPassword)
        }

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()

            if (username.isNotEmpty()) {
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("USERNAME", username)
                startActivity(intent)
            } else {
                etUsername.error = getString(R.string.username_required)
            }
        }
    }
}