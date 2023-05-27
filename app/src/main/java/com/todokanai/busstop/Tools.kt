package com.todokanai.busstop

import com.todokanai.busstop.room.retrofitdata.Station

class Tools {
    fun nodeIds(list:List<Station>):List<String>{
        val result = mutableListOf<String>()
        for(element in list){
            result.add(element.nodeid)
        }
        return result.distinct()
    }
}