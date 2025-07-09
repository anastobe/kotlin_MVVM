package com.example.auththree.data.repository
import retrofit2.Response  // ✅ This is the missing import
import com.example.auththree.data.model.LoginRequest
import com.example.auththree.data.model.LoginResponse
import com.example.auththree.data.remote.RetrofitClient

class LoginRepository {
    suspend fun loginUser(request: LoginRequest): Response<LoginResponse> {
        return RetrofitClient.apiService.login(request)
    }

}

