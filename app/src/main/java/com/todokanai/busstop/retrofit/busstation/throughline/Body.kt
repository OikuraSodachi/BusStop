package com.todokanai.busstop.retrofit.busstation.throughline

data class Body(
    val items: Items,
    val numOfRows: Int,
    val pageNo: Int,
    val totalCount: Int
)