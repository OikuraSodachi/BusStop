package com.todokanai.busstop.room.retrofitdata

data class BusArrive(
    // retrofit.busarrive
    val arrprevstationcnt: Int,
    val arrtime: Int,
    val nodeid: String,
    val nodenm: String,
    val routeid: String,
    val routeno: String,
    val routetp: String,
    val vehicletp: String
)
