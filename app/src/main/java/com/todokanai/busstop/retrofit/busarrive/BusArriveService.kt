package com.todokanai.busstop.retrofit.busarrive

import com.todokanai.busstop.retrofit.busarrive.stationlist.BusArriveResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BusArriveService {

    @GET("getSttnAcctoArvlPrearngeInfoList?serviceKey=7TU9szuK95yGTs7ptoWbuUKFk4S%2B4Q%2BAbOn1a4qImHQKSx2AgIdPxF7fG%2B2cgVIR8zD3fWwSWD8rTNV3cr2hsQ%3D%3D&pageNo=1&numOfRows=10&_type=json&cityCode=38030")
    fun getStationArrive(@Query("nodeId") nodeId: String ): Call<BusArriveResponse>       // 정류소별도착예정정보 목록 조회


}