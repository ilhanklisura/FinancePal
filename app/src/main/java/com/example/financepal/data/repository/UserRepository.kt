package com.example.financepal.data.repository

import com.example.financepal.data.dao.UserDao
import com.example.financepal.data.model.User

class UserRepository(private val userDao: UserDao) {

    suspend fun insertUser(user: User): Long {
        return userDao.insertUser(user)
    }

    suspend fun loginUser(username: String, password: String): User? {
        return userDao.loginUser(username, password)
    }

    suspend fun getCurrentUser(): User? {
        return userDao.getCurrentUser()
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }
}