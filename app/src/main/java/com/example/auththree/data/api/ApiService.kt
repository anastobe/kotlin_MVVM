package com.example.auththree.data.api
import retrofit2.Call
import retrofit2.http.GET
import com.example.auththree.data.model.LoginRequest
import com.example.auththree.data.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>


}

