//package com.example.auththree.data.repository
//
//import com.example.auththree.data.model.User
//
//class UserRepository {
//    fun getUsers(): List<User> {
//        return listOf(
//            User(1, "Ali"),
//            User(2, "Zainab"),
//            User(3, "Ahmed"),
//            User(4, "Ayesha"),
//            User(5, "Ali"),
//            User(6, "Zainab"),
//            User(7, "Ahmed"),
//            User(8, "Ayesha"),
//            User(9, "Ali"),
//            User(10, "Zainab"),
//            User(11, "Ahmed"),
//            User(12, "Ayesha"),
//            User(13, "Ali"),
//            User(14, "Zainab"),
//            User(15, "Ahmed"),
//            User(16, "Ayesha"),
//            User(17, "Zainab"),
//            User(18, "Ahmed"),
//            User(19, "Ayesha"),
//            User(20, "Ali"),
//            User(21, "Zainab"),
//            User(22, "Ahmed"),
//            User(23, "Ayesha")
//        )
//    }
//}



package com.example.auththree.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.auththree.data.api.RetrofitInstance
import com.example.auththree.data.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    fun getUsers(liveData: MutableLiveData<List<User>>) {
        RetrofitInstance.api.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    liveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e("API_ERROR", t.message ?: "Unknown error")
            }
        })
    }
}
