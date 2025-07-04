package com.example.auththree.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.auththree.data.model.User
import com.example.auththree.data.repository.UserRepository

class UserViewModel : ViewModel() {

    private val repository = UserRepository()

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    fun fetchUsers() {
//        _users.value = repository.getUsers()
        repository.getUsers(_users)
    }
}




