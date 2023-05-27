package com.todokanai.busstop.retrofit.busstation.throughline

import com.todokanai.busstop.room.retrofitdata.ThroughLine

data class Item(
    val endnodenm: String,
    val routeid: String,
    val routeno: String,
    val routetp: String,
    val startnodenm: String
)
{
    fun toThroughLine(): ThroughLine {
        return ThroughLine(endnodenm, routeid, routeno, routetp, startnodenm)
    }
}