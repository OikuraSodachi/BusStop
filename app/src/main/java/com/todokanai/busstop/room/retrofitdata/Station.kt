package com.todokanai.busstop.room.retrofitdata

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.gms.maps.model.LatLng

@Entity(tableName = "room_station")
data class Station(
    // retrofit.busstation.stationlist.item
    @ColumnInfo val gpslati: Double,        // 위도
    @ColumnInfo val gpslong: Double,        // 경도
    @ColumnInfo val nodeid: String,         // 노드 ID
    @ColumnInfo val nodenm: String,         // 이름
    @ColumnInfo val nodeno: Int             // 노드번호
) {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo
    var no : Long ? = null

    fun getLatLng():LatLng{
        return LatLng(gpslati,gpslong)
    }           // station의 LatLng 값 반환
}
