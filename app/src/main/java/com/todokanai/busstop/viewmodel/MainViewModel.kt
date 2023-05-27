package com.todokanai.busstop.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.todokanai.busstop.application.MyApplication
import com.todokanai.busstop.repository.DataStoreRepository
import com.todokanai.busstop.repository.StationRepository
import com.todokanai.busstop.repository.UserRepository
import com.todokanai.busstop.room.MyDatabase
import com.todokanai.busstop.room.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
    ) : ViewModel() {
    private val dataStoreRepository = DataStoreRepository()
    private val stationRepository = StationRepository(MyDatabase.getInstance(MyApplication.appContext).stationDao())


    fun getAll() = userRepository.getUsers().asLiveData()

    fun insert(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            userRepository.insert(user)
        }
    }

    suspend fun deleteAll(){
        userRepository.deleteAll()
    }

    suspend fun save(value:String){
        dataStoreRepository.saveString(value)
    }

    val load = dataStoreRepository.getString
    }