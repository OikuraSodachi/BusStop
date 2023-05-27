package com.todokanai.busstop.retrofit.busarrive.stationlist

data class Body(
    val items: Items,
    val numOfRows: Int,
    val pageNo: Int,
    val totalCount: Int
)