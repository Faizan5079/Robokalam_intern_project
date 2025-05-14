package com.ali.robokalamapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewPortfolioActivity : AppCompatActivity() {
    private lateinit var portfolioTextView: TextView
    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_portfolio)
        portfolioTextView = findViewById(R.id.portfolioTextView)
        db = AppDatabase.getDatabase(this)

        CoroutineScope(Dispatchers.IO).launch {
            val portfolios = db.portfolioDao().getAllPortfolios()
            val builder = StringBuilder()

            for (portfolio in portfolios) {
                builder.append("Name: ${portfolio.name}\n")
                builder.append("College: ${portfolio.college}\n")
                builder.append("Skills: ${portfolio.skills}\n")
                builder.append("Project: ${portfolio.projectTitle}\n")
                builder.append("Description: ${portfolio.projectDescription}\n\n")
            }

            runOnUiThread {
                portfolioTextView.text = builder.toString()
            }
        }

    }
}