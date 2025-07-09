package com.example.auththree.data.local

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.example.auththree.data.model.LoginResponse

class SessionManager(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences("user_session", Context.MODE_PRIVATE)
    private val editor = prefs.edit()
    private val gson = Gson()

    fun saveLoginResponse(response: LoginResponse) {
        val json = gson.toJson(response)
        editor.putString("login_response", json)
        editor.apply()
    }

    fun getLoginResponse(): LoginResponse? {
        val json = prefs.getString("login_response", null)
        return json?.let { gson.fromJson(it, LoginResponse::class.java) }
    }

    fun clearSession() {
        editor.clear().apply()
    }
}
