package com.todokanai.busstop.myobjects

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.MutableLiveData
import com.todokanai.busstop.application.MyApplication
import com.todokanai.busstop.room.MyDatabase

object MyObjects {
    val myDatabase = MyDatabase.getInstance(MyApplication.appContext)
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "mydatastore")
    val storedData = MutableLiveData<String>()
    val csvPath : String = "/storage/emulated/0/Android/data/com.todokanai.busstop"       // csv 파일의 경로
}