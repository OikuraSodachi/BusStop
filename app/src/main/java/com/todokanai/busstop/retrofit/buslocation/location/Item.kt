package com.todokanai.busstop.retrofit.buslocation.location

import com.todokanai.busstop.room.retrofitdata.BusLocation

data class Item(
    val gpslati: Double,
    val gpslong: Double,
    val nodeid: String,
    val nodenm: String,
    val nodeord: Int,
    val routenm: Int,
    val routetp: String,
    val vehicleno: String
){
    fun toBusLocation(): BusLocation{
        return BusLocation(gpslati,gpslong,nodeid,nodenm,nodeord,routenm,routetp,vehicleno)
    }
}