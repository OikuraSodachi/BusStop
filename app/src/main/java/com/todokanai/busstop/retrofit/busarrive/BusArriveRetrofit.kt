package com.todokanai.busstop.retrofit.busarrive

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BusArriveRetrofit {

    val BASE_URL = "http://apis.data.go.kr/1613000/ArvlInfoInqireService/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}