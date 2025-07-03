package com.example.auththree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var name = findViewById<EditText>(R.id.name)
        var button = findViewById<Button>(R.id.submit)
//        val button = view.findViewById<Button>(R.id.submit)

        button.setOnClickListener{

//            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)


//            if (name.text.isEmpty()){
//                Toast.makeText(this, "Please write the name", Toast.LENGTH_SHORT).show()
//            }
//            else{

//                val intent = Intent(this, SecondActivity::class.java)
//                intent.putExtra("name", name.text.toString())
//                startActivity(intent)

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
//            finish() // closes current activity



//            }
        }

    }
}

