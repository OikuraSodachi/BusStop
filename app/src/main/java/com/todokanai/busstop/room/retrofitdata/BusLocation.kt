package com.todokanai.busstop.room.retrofitdata

data class BusLocation(
    // retrofit.buslocation
    val gpslati: Double,
    val gpslong: Double,
    val nodeid: String,
    val nodenm: String,
    val nodeord: Int,
    val routenm: Int,
    val routetp: String,
    val vehicleno: String
)
