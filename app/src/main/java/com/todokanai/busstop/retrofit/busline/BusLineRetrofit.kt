package com.todokanai.busstop.retrofit.busline

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BusLineRetrofit {

    val BASE_URL = "http://apis.data.go.kr/1613000/BusRouteInfoInqireService"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}