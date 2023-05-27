package com.todokanai.busstop.retrofit.buslocation.location

data class Body(
    val items: Items,
    val numOfRows: Int,
    val pageNo: Int,
    val totalCount: Int
)