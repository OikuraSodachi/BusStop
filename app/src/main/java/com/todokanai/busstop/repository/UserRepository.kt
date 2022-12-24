package com.todokanai.busstop.repository

import androidx.lifecycle.asLiveData
import com.todokanai.busstop.room.User
import com.todokanai.busstop.room.UserDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val userDao: UserDao) {

    fun getUsers() = userDao.getAll().asLiveData()

    suspend fun insert(user : User) = userDao.insert(user)

    suspend fun delete(user : User){
        userDao.delete(user)
    }

    suspend fun deleteAll(){
        userDao.deleteAll()
    }
}