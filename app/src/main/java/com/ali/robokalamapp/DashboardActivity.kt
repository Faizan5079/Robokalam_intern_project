package com.ali.robokalamapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.content.Context
import android.content.Intent
import android.widget.Button
import kotlinx.coroutines.*


class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)

        val prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val email = prefs.getString("email", "Student")

        val welcomeText = findViewById<TextView>(R.id.textWelcome)
        welcomeText.text = "Welcome, $email!"

        // Button Click Listeners
        findViewById<Button>(R.id.buttonPortfolio).setOnClickListener {
            startActivity(Intent(this, PortfolioActivity::class.java))
        }

        findViewById<Button>(R.id.buttonQuote).setOnClickListener {
            startActivity(Intent(this, QuoteActivity::class.java))
        }

        findViewById<Button>(R.id.buttonAbout).setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }

        findViewById<Button>(R.id.buttonLogout).setOnClickListener {
            prefs.edit().clear().apply()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

    }
}

