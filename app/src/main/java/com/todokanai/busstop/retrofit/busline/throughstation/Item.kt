package com.todokanai.busstop.retrofit.busline.throughstation

import com.todokanai.busstop.room.retrofitdata.ThroughStation

data class Item(
    val gpslati: Double,
    val gpslong: Double,
    val nodeid: String,
    val nodenm: String,
    val nodeno: Int,
    val nodeord: Int,
    val routeid: String
){
    fun toThroughStation(): ThroughStation {
        return ThroughStation(gpslati,gpslong,nodeid,nodenm,nodeno,nodeord,routeid)
    }
}