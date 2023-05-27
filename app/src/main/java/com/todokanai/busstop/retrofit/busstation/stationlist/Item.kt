package com.todokanai.busstop.retrofit.busstation.stationlist

import com.todokanai.busstop.room.retrofitdata.Station

data class Item(
    val gpslati: Double,        // 위도
    val gpslong: Double,        // 경도
    val nodeid: String,         // 노드 ID
    val nodenm: String,         // 이름
    val nodeno: Int             // 노드번호
){
    fun toStation(): Station {
        return Station(gpslati,gpslong,nodeid,nodenm,nodeno)
    }

}