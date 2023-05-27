package com.todokanai.busstop.retrofit.busarrive.stationlist

import com.todokanai.busstop.room.retrofitdata.BusArrive

data class Item(
    val arrprevstationcnt: Int,
    val arrtime: Int,
    val nodeid: String,
    val nodenm: String,
    val routeid: String,
    val routeno: String,
    val routetp: String,
    val vehicletp: String
) {
    fun toBusArrive(): BusArrive {
        return BusArrive(arrprevstationcnt,arrtime,nodeid,nodenm,routeid,routeno,routetp,vehicletp)
    }
}