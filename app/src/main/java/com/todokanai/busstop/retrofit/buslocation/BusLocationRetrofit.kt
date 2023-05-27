package com.todokanai.busstop.retrofit.buslocation

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BusLocationRetrofit {
    val BASE_URL = "http://apis.data.go.kr/1613000/BusLcInfoInqireService"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}