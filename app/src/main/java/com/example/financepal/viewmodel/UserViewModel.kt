package com.example.financepal.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.financepal.data.AppDatabase
import com.example.financepal.data.model.User
import com.example.financepal.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepository

    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser

    init {
        val userDao = AppDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
    }

    fun insertUser(user: User) {
        viewModelScope.launch {
            val userId = repository.insertUser(user)
            if (userId > 0) {
                _currentUser.value = user
            }
        }
    }

    fun loginUser(username: String, password: String) {
        viewModelScope.launch {
            _currentUser.value = repository.loginUser(username, password)
        }
    }

    fun getCurrentUser() {
        viewModelScope.launch {
            _currentUser.value = repository.getCurrentUser()
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch {
            repository.updateUser(user)
            _currentUser.value = user
        }
    }
}