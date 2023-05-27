package com.todokanai.busstop.retrofit.buslocation

import com.todokanai.busstop.retrofit.buslocation.location.BusLocationResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BusLocationService {

    @GET("getRouteAcctoBusLcList?serviceKey=7TU9szuK95yGTs7ptoWbuUKFk4S%2B4Q%2BAbOn1a4qImHQKSx2AgIdPxF7fG%2B2cgVIR8zD3fWwSWD8rTNV3cr2hsQ%3D%3D&pageNo=1&numOfRows=20&_type=json&cityCode=38030")
    fun getBusLocation(@Query("routeId") routeId: String) : Call<BusLocationResponse>
}