package com.example.auththree
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        var buttonClock = findViewById<Button>(R.id.buttonClock)
        var buttonExam = findViewById<Button>(R.id.buttonExam)


        buttonClock.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ClockFragment())
                .addToBackStack(null)
                .commit()
        }

        buttonExam.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ExamFragment())
                .addToBackStack(null)
                .commit()
        }


    }
}

