package com.todokanai.busstop.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StationDao {

    @Query("select * from room_station")
    fun getAll(): Flow<List<Station>>

    @Insert
    suspend fun insert(station: Station)

    @Query("Delete from room_station")
    suspend fun deleteAll()

}