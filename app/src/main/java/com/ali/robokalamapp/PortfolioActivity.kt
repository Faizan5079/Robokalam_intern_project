package com.ali.robokalamapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.widget.EditText
import android.widget.Button
import android.content.Intent


class PortfolioActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_portfolio)
        // Initialize Room Database
        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "portfolio-db").build()

        val nameEditText = findViewById<EditText>(R.id.editName)
        val collegeEditText = findViewById<EditText>(R.id.editCollege)
        val skillsEditText = findViewById<EditText>(R.id.editSkills)
        val projectTitleEditText = findViewById<EditText>(R.id.editProjectTitle)
        val projectDescriptionEditText = findViewById<EditText>(R.id.editProjectDescription)
        val saveButton = findViewById<Button>(R.id.buttonSave)

        // Save button click listener
        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val college = collegeEditText.text.toString()
            val skills = skillsEditText.text.toString()
            val projectTitle = projectTitleEditText.text.toString()
            val projectDescription = projectDescriptionEditText.text.toString()

            val portfolio = Portfolio(0, name, college, skills, projectTitle, projectDescription)

            // Insert using coroutine on IO thread
            CoroutineScope(Dispatchers.IO).launch {
                db.portfolioDao().insertPortfolio(portfolio)

                // Show toast on main thread
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@PortfolioActivity,
                        "Saved Successfully!",
                        Toast.LENGTH_SHORT
                    ).show()

                    // Optional: move to view screen
                    val intent = Intent(this@PortfolioActivity, ViewPortfolioActivity::class.java)
                    startActivity(intent)
                }
            }
                // Function to insert portfolio data into Room DB
                 fun savePortfolioToDatabase(name: String, college: String, skills: String, projectTitle: String, projectDescription: String) {
                    CoroutineScope(Dispatchers.IO).launch {
                        val portfolio = Portfolio(name = name, college = college, skills = skills, projectTitle = projectTitle, projectDescription = projectDescription)

                        db.portfolioDao().insertPortfolio(portfolio)

                    }
        }

    }
    }
        }


