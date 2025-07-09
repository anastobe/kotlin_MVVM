package com.example.auththree.ui.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auththree.data.model.LoginRequest
import com.example.auththree.data.model.LoginResponse
import com.example.auththree.data.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val repository = LoginRepository()
    val loginResult = MutableLiveData<Result<LoginResponse>>()

    fun login(loginId: String, password: String, deviceId: String) {
        viewModelScope.launch {
            try {
                val request = LoginRequest(loginId, password, deviceId)
                val response = repository.loginUser(request)

                if (response.isSuccessful && response?.body() != null) {

                    println("🔁 Response body: ${response?.body()}")


                    loginResult.postValue(Result.success(response.body()!!))
                } else {
                    val errorBody = response.errorBody()?.string()
                    println("❌ Login failed → Code: ${response.code()}, Error: $errorBody")
                    loginResult.postValue(Result.failure(Exception("Login failed → Code: ${response.code()}, Error: $errorBody")))
                }


            } catch (e: Exception) {
                loginResult.postValue(Result.failure(e))
            }
        }
    }
}
