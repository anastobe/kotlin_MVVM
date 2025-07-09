package com.example.auththree.data.model

data class LoginRequest(
    val login_id: String,
    val password: String,
    val device_id: String
)
