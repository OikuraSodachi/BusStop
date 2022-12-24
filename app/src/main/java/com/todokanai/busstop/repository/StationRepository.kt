package com.todokanai.busstop.repository

import com.todokanai.busstop.room.Station
import com.todokanai.busstop.room.StationDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StationRepository @Inject constructor(private val stationDao: StationDao){

    suspend fun insert(station: Station) = stationDao.insert(station)

    suspend fun deleteAll() = stationDao.deleteAll()

}