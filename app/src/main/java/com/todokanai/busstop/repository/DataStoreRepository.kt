package com.todokanai.busstop.repository

import androidx.datastore.preferences.core.*
import com.todokanai.busstop.application.MyApplication
import com.todokanai.busstop.myobjects.MyObjects.dataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class DataStoreRepository {
    companion object{
        val DATASTORE_DATA = stringPreferencesKey("dataStore_data")
        val DATASTORE_ZOOM = floatPreferencesKey("dataStore_zoom")
        val DATASTORE_LAT = doublePreferencesKey("dataStore_lat")
        val DATASTORE_LNG = doublePreferencesKey("dataStore_lng")
        val DATASTORE_ISFIRSTRUN = booleanPreferencesKey("dataStore_isFirstRun")
    }
    private val myContext = MyApplication.appContext

    fun saveString(value: String) {
        CoroutineScope(Dispatchers.IO).launch {
            myContext.dataStore.edit {
                it[DATASTORE_DATA] = value
            }
        }
    }

    fun saveZoom(zoomLevel:Float){
        CoroutineScope(Dispatchers.IO).launch {
            myContext.dataStore.edit {
                it[DATASTORE_ZOOM] = zoomLevel
            }
        }
    }

    fun saveLat(latitude:Double){
        CoroutineScope(Dispatchers.IO).launch {
            myContext.dataStore.edit {
                it[DATASTORE_LAT] = latitude
            }
        }
    }

    fun saveLng(longitude:Double){
        CoroutineScope(Dispatchers.IO).launch {
            myContext.dataStore.edit {
                it[DATASTORE_LNG] = longitude
            }
        }
    }

    fun saveRun(boolean:Boolean){
        CoroutineScope(Dispatchers.IO).launch {
            myContext.dataStore.edit {
                it[DATASTORE_ISFIRSTRUN] = boolean
            }
        }
    }

    fun saveCameraFocus(zoomLevel:Float,latitude:Double,longitude:Double){
        saveZoom(zoomLevel)
        saveLat(latitude)
        saveLng(longitude)
    }

    val getZoom : Flow<Float?> = myContext.dataStore.data.map {
        it[DATASTORE_ZOOM]
    }

    val getLat : Flow<Double?> = myContext.dataStore.data.map {
        it[DATASTORE_LAT]
    }

    val getLng : Flow<Double?> = myContext.dataStore.data.map {
        it[DATASTORE_LNG]
    }

    val getString : Flow<String?> = myContext.dataStore.data.map {
        it[DATASTORE_DATA]
    }

    val getFirstRun : Flow<Boolean?> = myContext.dataStore.data.map{
        it[DATASTORE_ISFIRSTRUN]
    }

}