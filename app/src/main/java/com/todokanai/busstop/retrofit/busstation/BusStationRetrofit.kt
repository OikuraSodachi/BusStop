package com.todokanai.busstop.retrofit.busstation

import com.todokanai.busstop.room.retrofitdata.ThroughLine
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BusStationRetrofit {

    val BASE_URL = "http://apis.data.go.kr/1613000/BusSttnInfoInqireService/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
