package com.todokanai.busstop.myobjects

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.MutableLiveData
import com.todokanai.busstop.Constants.STATUS_DEFAULT
import com.todokanai.busstop.application.MyApplication
import com.todokanai.busstop.room.MyDatabase
import com.todokanai.busstop.room.retrofitdata.BusArrive

object MyObjects {
    val myDatabase = MyDatabase.getInstance(MyApplication.appContext)
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "mydatastore")
    val storedData = MutableLiveData<String>()
 }