package com.example.auththree

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.auththree.data.local.SessionManager
import com.example.auththree.databinding.ActivitySecondBinding

class SecondActivity : ComponentActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout FIRST
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get data from shared preferences
        val sessionManager = SessionManager(this)
        val loginData = sessionManager.getLoginResponse()

        // ✅ Use view binding
        binding.nameTextView.text = "Name: ${loginData?.user?.full_name}"
    }
}
