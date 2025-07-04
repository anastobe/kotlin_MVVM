//package com.example.auththree
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
////        var name = findViewById<EditText>(R.id.name)
//        var button = findViewById<Button>(R.id.submit)
////        val button = view.findViewById<Button>(R.id.submit)
//
//        button.setOnClickListener{
//
////            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
//
//
////            if (name.text.isEmpty()){
////                Toast.makeText(this, "Please write the name", Toast.LENGTH_SHORT).show()
////            }
////            else{
//
////                val intent = Intent(this, SecondActivity::class.java)
////                intent.putExtra("name", name.text.toString())
////                startActivity(intent)
//
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
////            finish() // closes current activity
//
//
//
////            }
//        }
//
//    }
//}




package com.example.auththree

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.auththree.databinding.ActivityMainBinding
import com.example.auththree.ui.adapter.UserAdapter
import com.example.auththree.ui.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        userViewModel.users.observe(this) { userList ->
            binding.recyclerView.adapter = UserAdapter(userList)
        }

        userViewModel.fetchUsers()
    }
}
