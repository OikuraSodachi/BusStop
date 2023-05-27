package com.todokanai.busstop.retrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.todokanai.busstop.retrofit.busarrive.stationlist.BusArriveResponse
import com.todokanai.busstop.retrofit.busarrive.BusArriveRetrofit
import com.todokanai.busstop.retrofit.busarrive.BusArriveService
import com.todokanai.busstop.retrofit.busline.BusLineRetrofit
import com.todokanai.busstop.retrofit.busline.BusLineService
import com.todokanai.busstop.retrofit.busline.throughstation.BusLineThroughResponse
import com.todokanai.busstop.retrofit.buslocation.location.BusLocationResponse
import com.todokanai.busstop.retrofit.buslocation.BusLocationRetrofit
import com.todokanai.busstop.retrofit.buslocation.BusLocationService
import com.todokanai.busstop.retrofit.busstation.stationlist.BusStationResponse
import com.todokanai.busstop.retrofit.busstation.BusStationRetrofit
import com.todokanai.busstop.retrofit.busstation.BusStationService
import com.todokanai.busstop.retrofit.busstation.throughline.ThroughLineResponse
import com.todokanai.busstop.room.retrofitdata.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitRepository {

    val arriveDataHolder = MutableLiveData<List<BusArrive>>()
    val throughLineDataHolder = MutableLiveData<List<ThroughLine>>()

    fun getBusArrive(nodeId:String){
        val result = mutableListOf<BusArrive>()
        BusArriveRetrofit.retrofit.create(BusArriveService::class.java)
            .getStationArrive(nodeId).enqueue(object : Callback<BusArriveResponse> {
            override fun onFailure(call: Call<BusArriveResponse>, t: Throwable) {
                Log.d("busArriveTest", "onFailure:  $t")
            }
            override fun onResponse(
                call: Call<BusArriveResponse>,
                response: Response<BusArriveResponse>
            ) {
                val number = response.body()!!.response.body.totalCount
                for (index in 0..number - 1) {
                    val mItem = response.body()!!.response.body.items.item[index]
                    result.add(mItem.toBusArrive())
                }
                arriveDataHolder.value = result
            }
        })
    }

    fun getAllStation() : Flow<List<Station>> {
        val result = mutableListOf<Station>()
        BusStationRetrofit.retrofit.create(BusStationService::class.java)
            .getBus().enqueue(object : Callback<BusStationResponse> {
                override fun onFailure(call: Call<BusStationResponse>, t: Throwable) {
                    Log.d("busRetrofitTest", "onFailure:  $t")
                }
                override fun onResponse(
                    call: Call<BusStationResponse>,
                    response: Response<BusStationResponse>
                ) {
                    val number = response.body()!!.response.body.totalCount
                    for (index in 0..number - 1) {
                        result.add(response.body()!!.response.body.items.item[index].toStation())
                    }
                }
            })
        return flowOf(result)
    }       // done

    fun getBusLocation(routeId:String) : Flow<List<BusLocation>> {

        val result = mutableListOf<BusLocation>()
        val busLocationService = BusLocationRetrofit.retrofit.create(BusLocationService::class.java)

        busLocationService.getBusLocation(routeId).enqueue(object : Callback<BusLocationResponse> {
            override fun onFailure(call: Call<BusLocationResponse>, t: Throwable) {
                Log.d("busArriveTest", "onFailure:  $t")
            }

            override fun onResponse(
                call: Call<BusLocationResponse>,
                response: Response<BusLocationResponse>
            ) {
                val number = response.body()!!.response.body.totalCount

                for (index in 0..number - 1) {
                    result.add(response.body()!!.response.body.items.item[index].toBusLocation())
                }
            }
        })
        return flowOf(result)
    }       // done

    fun getThroughLine(nodeId:String) : Flow<List<ThroughLine>> {
        val result = mutableListOf<ThroughLine>()

        val service = BusStationRetrofit.retrofit.create(BusStationService::class.java)
        service.getThroughLine(nodeId).enqueue(object : Callback<ThroughLineResponse> {
            override fun onFailure(call: Call<ThroughLineResponse>, t: Throwable) {
                Log.d("busRetrofit_getThroughLine", "onFailure:  $t")
            }

            override fun onResponse(
                call: Call<ThroughLineResponse>,
                         response: Response<ThroughLineResponse>
            ) {
                val number = response.body()!!.response.body.totalCount
                for (index in 0..number - 1) {
                    result.add(response.body()!!.response.body.items.item[index].toThroughLine())
                }
                throughLineDataHolder.value = result
            }
        })
        return flowOf(result)
    }           // done

    fun getThroughLine2()  {
        val result = mutableListOf<ThroughLine>()

        val service = BusStationRetrofit.retrofit.create(BusStationService::class.java)
        service.getTestLine().enqueue(object : Callback<ThroughLineResponse> {
            override fun onFailure(call: Call<ThroughLineResponse>, t: Throwable) {
                Log.d("busRetrofit_getThroughLine", "onFailure:  $t")
            }

            override fun onResponse(
                call: Call<ThroughLineResponse>,
                response: Response<ThroughLineResponse>
            ) {
                val number = response.body()!!.response.body.totalCount
                for (index in 0..number - 1) {
                    result.add(response.body()!!.response.body.items.item[index].toThroughLine())
                }
                throughLineDataHolder.value = result
            }
        })
    }           // JJB381249017


    fun getThroughStation(routeId: String) : Flow<List<ThroughStation>> {
        val result = mutableListOf<ThroughStation>()
        val service = BusLineRetrofit.retrofit.create(BusLineService::class.java)

        service.getThroughStation(routeId).enqueue(object : Callback<BusLineThroughResponse> {
            override fun onFailure(call: Call<BusLineThroughResponse>, t: Throwable) {
                Log.d("busRetrofitTest", "onFailure:  $t")
            }
            override fun onResponse(
                call: Call<BusLineThroughResponse>,
                response: Response<BusLineThroughResponse>
            ) {
                val number = response.body()!!.response.body.totalCount
                for (index in 0..number - 1) {
                    result.add(response.body()!!.response.body.items.item[index].toThroughStation())
                }
            }
        })
        return flowOf(result)
    }       // done
}