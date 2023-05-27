package com.todokanai.busstop.viewmodel

import androidx.lifecycle.*
import com.todokanai.busstop.Constants.STATUS_DEFAULT
import com.todokanai.busstop.Constants.STATUS_END
import com.todokanai.busstop.Constants.STATUS_START
import com.todokanai.busstop.repository.DataStoreRepository
import com.todokanai.busstop.repository.StationRepository
import com.todokanai.busstop.retrofit.RetrofitRepository
import com.todokanai.busstop.room.retrofitdata.BusArrive
import com.todokanai.busstop.room.retrofitdata.Station
import com.todokanai.busstop.room.retrofitdata.ThroughLine
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(private val stationRepository: StationRepository):ViewModel(){

    lateinit var allStationListHolder : List<Station>

    private val dataStore = DataStoreRepository()
    private val retrofitRepo = RetrofitRepository()
    val cameraZoom = dataStore.getZoom.asLiveData().value ?:17f
    val cameraLat = dataStore.getLat.asLiveData().value ?:35.17955300829925
    val cameraLng = dataStore.getLng.asLiveData().value ?:128.14824426546693
    val map_status = MutableLiveData<Int>(STATUS_DEFAULT)       // 범위선택모드 판별
    var currentNodeId : String? = null      // testNodeId 일반버전

    val arriveDataHolder : LiveData<List<BusArrive>> = retrofitRepo.arriveDataHolder
    val startLineDataHolder : LiveData<List<ThroughLine>> = retrofitRepo.throughLineDataHolder
    val endLineDataHolder : LiveData<List<ThroughLine>> = retrofitRepo.throughLineDataHolder

    fun prepareAllStation(){
        viewModelScope.launch {
            stationRepository.getAllFromNet().collect(){
                allStationListHolder = it
            }
        }
    }

    fun insertCameraFocus(zoomLevel:Float,latitude:Double,longitude:Double) {
        dataStore.saveCameraFocus(zoomLevel,latitude,longitude)
    }
    fun updateCurrentNodeId(nodeId:String?){
        nodeId?.let{currentNodeId = nodeId}
    }// 입력값이 null이면 단순 새로고침, null이 아니면 currentNodeId 값 변경후 새로고침
    fun updateArrive() = currentNodeId?.let { retrofitRepo.getBusArrive(it) }
    fun updateThroughLine(nodeId:String) = retrofitRepo.getThroughLine(nodeId)

    //-------------------------------------------------

    private val startStationList = mutableListOf<Station>()                    // 출발지점 담는 변수
    private val endStationList = mutableListOf<Station>()                        // 도착지점 담는 변수

    private val _startStation = MutableLiveData<List<Station>>(emptyList())     // 출발지점 담는 변수.livedata    // 확정
    val startStation : LiveData<List<Station>>
        get() = _startStation                                                 // 읽기 전용으로 변환

    private val _endStation = MutableLiveData<List<Station>>(emptyList())     // 도착지점 담는 변수.livedata     // 확정
    val endStation : LiveData<List<Station>>
        get() = _endStation
    
    val _areaThrough = MutableLiveData<List<String>>(emptyList())      // 범위검색 결과 노선 리스트
    val areaThrough : LiveData<List<String>>
        get() = _areaThrough

    fun startMode(){
        map_status.value = STATUS_START
    }
    fun endMode(){
        map_status.value = STATUS_END
    }
    fun defaultMode(){
        map_status.value = STATUS_DEFAULT
    }
    fun addToStart(station:Station){
        startStationList.add(station)
        _startStation.value = startStationList.distinct()
    }
    fun addToEnd(station: Station){
        endStationList.add(station)
        _endStation.value = endStationList.distinct()
    }



}



