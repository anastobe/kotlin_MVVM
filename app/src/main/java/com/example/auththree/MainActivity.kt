package com.example.auththree

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.auththree.data.local.SessionManager
import com.example.auththree.ui.viewmodel.LoginViewModel

class MainActivity : AppCompatActivity() {

//    private lateinit var viewModel: LoginViewModel  // Move it here
    private val viewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginIdField = findViewById<EditText>(R.id.name)
        val passwordField = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.submit)
        val buttonShowTab = findViewById<Button>(R.id.buttonShowTab)


        buttonShowTab.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            val loginId = "0334334"
            val password = "91r+ciMmICk=:V739S7GOGVQKNBu5:7A4IrCxoTHZxD9iX1tJI0Q=="
            val deviceId = "321321"

            println("Login Info -> loginId: $loginId, password: $password, deviceId: $deviceId")

            if (loginId.isNotEmpty() && password.isNotEmpty()) {
                viewModel.login(loginId, password, deviceId)
            } else {
                Toast.makeText(this, "Please enter both fields", Toast.LENGTH_SHORT).show()
            }
        }


        viewModel.loginResult.observe(this, Observer { result ->
            result.onSuccess { loginResponse ->

            Toast.makeText(this, "Login Success! Token: token XYZ", Toast.LENGTH_LONG).show()

                val sessionManager = SessionManager(this)
                sessionManager.saveLoginResponse(loginResponse)

                Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show()

                // Navigate to next screen
                val intent = Intent(this, ThirdActivity::class.java)
                startActivity(intent)
//                finish()

            }
                result.onFailure {

//                    val intent = Intent(this, ThirdActivity::class.java)
//                    startActivity(intent)

                    Toast.makeText(this, "Login Failed: ${it.message}", Toast.LENGTH_LONG).show()
                    it.printStackTrace()  // ✅ helpful in Logcat

                    println("===========FAIL=======: $this")
//                Toast.makeText(this, "Login Failed: XYZ message", Toast.LENGTH_LONG).show()
            }
        })




    }
}
