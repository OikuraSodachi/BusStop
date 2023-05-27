package com.todokanai.busstop.room.retrofitdata

data class ThroughStation(
    // retrofit.busline.throughstation
    val gpslati: Double,
    val gpslong: Double,
    val nodeid: String,
    val nodenm: String,
    val nodeno: Int,
    val nodeord: Int,
    val routeid: String
)
