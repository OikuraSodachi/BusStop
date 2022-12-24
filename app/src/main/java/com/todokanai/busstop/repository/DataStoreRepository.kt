package com.todokanai.busstop.repository

import android.util.Log
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.todokanai.busstop.application.MyApplication
import com.todokanai.busstop.myobjects.MyObjects.dataStore
import kotlinx.coroutines.flow.*

class DataStoreRepository {
    companion object{
        val DATASTORE_DATA = stringPreferencesKey("dataStore_data")
    }
    private val myContext = MyApplication.appContext

    suspend fun save( value: String) {
        myContext.dataStore.edit {
            it[DATASTORE_DATA] = value
            Log.d("tester","insert: $value")
        }
    }

    val loadAsLiveData : LiveData<String?> = myContext.dataStore.data.map {
        it[DATASTORE_DATA]
    }.asLiveData()

    val loadAsFlow : Flow<String?> = myContext.dataStore.data.map {
        it[DATASTORE_DATA]
    }
}