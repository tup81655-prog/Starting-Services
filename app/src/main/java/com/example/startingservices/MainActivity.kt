package com.example.startingservices

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_COUNT = "extra_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputNumber = findViewById<EditText>(R.id.inputNumber)
        val startButton = findViewById<Button>(R.id.startButton)

        startButton.setOnClickListener {
            val number = inputNumber.text.toString().toIntOrNull()
            if (number != null) {
                val intent = Intent(this, CountdownService::class.java)
                intent.putExtra(EXTRA_COUNT, number)
                startService(intent) // Start Service
            }
        }
    }
}