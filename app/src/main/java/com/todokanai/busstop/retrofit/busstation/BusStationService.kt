package com.todokanai.busstop.retrofit.busstation

import com.todokanai.busstop.retrofit.busstation.stationlist.BusStationResponse
import com.todokanai.busstop.retrofit.busstation.throughline.ThroughLineResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BusStationService {

  @GET("getSttnNoList?serviceKey=7TU9szuK95yGTs7ptoWbuUKFk4S%2B4Q%2BAbOn1a4qImHQKSx2AgIdPxF7fG%2B2cgVIR8zD3fWwSWD8rTNV3cr2hsQ%3D%3D&_type=json&cityCode=38030&numOfRows=3000")          // baseUrl의 뒷부분
  fun getBus(): Call<BusStationResponse>     // 정류소번호 목록조회

  @GET("getSttnThrghRouteList?serviceKey=7TU9szuK95yGTs7ptoWbuUKFk4S%2B4Q%2BAbOn1a4qImHQKSx2AgIdPxF7fG%2B2cgVIR8zD3fWwSWD8rTNV3cr2hsQ%3D%3D&pageNo=1&numOfRows=50&_type=json&cityCode=38030")
  fun getThroughLine(@Query("nodeid") nodeid : String): Call<ThroughLineResponse>

  @GET("getSttnThrghRouteList?serviceKey=7TU9szuK95yGTs7ptoWbuUKFk4S%2B4Q%2BAbOn1a4qImHQKSx2AgIdPxF7fG%2B2cgVIR8zD3fWwSWD8rTNV3cr2hsQ%3D%3D&pageNo=1&numOfRows=50&_type=json&cityCode=38030&nodeid=JJB381249017")
  fun getTestLine() : Call<ThroughLineResponse>
}