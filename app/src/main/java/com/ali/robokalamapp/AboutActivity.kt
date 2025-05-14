package com.ali.robokalamapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageView
import android.widget.TextView

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)
        val aboutImage = findViewById<ImageView>(R.id.aboutImage)
        val aboutText = findViewById<TextView>(R.id.aboutText)

        // Optionally, you can change the image or text dynamically if needed
        aboutText.text = "Robokalam is a platform that aims to bridge the gap between technical skills and innovation."

        // aboutImage.setImageResource(R.drawable.some_other_image)  // If you want to change the image dynamically


    }
}