package com.example.auththree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.util.Log

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

//        val setName = findViewById<TextView>(R.id.setName)
//        val name = intent.getStringExtra("name")

//        Log.d("SecondActivity", "Received name: $name")

//        setName.text = name ?: "No Name Provided" // ✅ Handle null case
    }
}