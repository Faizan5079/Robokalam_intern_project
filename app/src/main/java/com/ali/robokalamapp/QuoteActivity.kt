package com.ali.robokalamapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import kotlinx.coroutines.*


class QuoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quote)
        val quoteTextView = findViewById<TextView>(R.id.quoteTextView)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.api.getQuote()
                val quote = response.firstOrNull()
                withContext(Dispatchers.Main) {
                    if (quote != null) {
                        quoteTextView.text = "\"${quote.q}\"\n\n– ${quote.a}"
                    } else {
                        quoteTextView.text = "No quote available today."
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    quoteTextView.text = "Failed to load quote."
                }
            }
        }

    }
}