package com.todokanai.busstop.retrofit.busline.throughstation

data class Body(
    val items: Items,
    val numOfRows: Int,
    val pageNo: Int,
    val totalCount: Int
)