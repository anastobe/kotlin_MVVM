package com.example.auththree.data.api
import com.example.auththree.data.model.User
import retrofit2.Call
import retrofit2.http.GET
import com.example.auththree.data.model.LoginRequest
import com.example.auththree.data.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @GET("users")
    fun getUsers(): Call<List<User>>

    // New POST login (suspend function)
//    @POST("login")
//    fun login(
//        suspend @Body request: LoginRequest): Response<LoginResponse>

    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>


}

