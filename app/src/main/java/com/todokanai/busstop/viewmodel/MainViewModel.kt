package com.todokanai.busstop.viewmodel

import android.content.res.AssetManager
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.todokanai.busstop.CsvHelper
import com.todokanai.busstop.application.MyApplication
import com.todokanai.busstop.myobjects.MyObjects
import com.todokanai.busstop.repository.DataStoreRepository
import com.todokanai.busstop.repository.StationRepository
import com.todokanai.busstop.repository.UserRepository
import com.todokanai.busstop.room.Station
import com.todokanai.busstop.room.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.serialization.json.JsonNull.content
import java.io.InputStream

import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val stationRepository: StationRepository
    ) : ViewModel() {

    private val FILE_NAME_1 = "bus.csv"        // csv 파일의 이름

    val assetManager : AssetManager = MyApplication.appContext.assets
    val inputStream : InputStream = assetManager.open("bus.csv")

    val csvHelper = CsvHelper(MyObjects.csvPath)
    var readdataList = csvHelper.readAllCsvData(FILE_NAME_1)

   suspend fun insertBtn() {
       /*
        for (data in readdataList) {
            Log.d("openCsv", "data : ${data.contentDeepToString()}")
        }
        */

       for(index in 0..readdataList.size-1){


           val mRegex = Regex("[^A-Za-z0-9]")

           val csvToRoom : List<String> = readdataList[index].contentDeepToString().split(",",)
           Log.d("oikura","test: ${csvToRoom[0].replace("[","")}")
           val toRoom : Station = Station(csvToRoom[0].replace("[","").toInt(),  csvToRoom[1],csvToRoom[2].toDouble(),csvToRoom[3].toDouble(),csvToRoom[4].toInt(),csvToRoom[5])

          // stationRepository.insert(toRoom)
       }
    }


    private val dataStoreRepository = DataStoreRepository()

    fun getAll() = userRepository.getUsers()

    fun insert(user: User) {
        viewModelScope.launch {
            userRepository.insert(user)
        }
    }

    suspend fun deleteAll(){
        userRepository.deleteAll()
    }

    suspend fun save(value:String){
        dataStoreRepository.save(value)
    }

    val load = dataStoreRepository.loadAsLiveData

}