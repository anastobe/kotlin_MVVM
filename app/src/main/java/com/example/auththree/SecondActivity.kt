package com.example.auththree

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.auththree.databinding.ActivitySecondBinding
import com.example.auththree.ui.adapter.UserAdapter
import com.example.auththree.ui.viewmodel.UserViewModel


class SecondActivity : ComponentActivity() {

    private lateinit var binding: ActivitySecondBinding
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        userViewModel.users.observe(this) { userList ->
            binding.recyclerView.adapter = UserAdapter(userList)
        }

        userViewModel.fetchUsers()
    }
}

