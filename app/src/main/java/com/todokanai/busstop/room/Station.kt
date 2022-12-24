package com.todokanai.busstop.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "room_station")
data class Station(
    @ColumnInfo val station_node_id : Int,      // 정류소노드 ID
    @ColumnInfo val name : String,              // 정류소명
    @ColumnInfo val longitude : Double,               // 경도
    @ColumnInfo val latitude : Double,                // 위도
    @ColumnInfo val stateCode : Int,            // 지자체코드
    @ColumnInfo val stateName : String          // 지자체명
) {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo
    var no : Long ? = null

    override fun toString(): String {
        return "Station(station_node_id=$station_node_id, name='$name', longitude=$longitude, latitude=$latitude, stateCode=$stateCode, stateName='$stateName')"
    }

}

// 출처: https://www.data.go.kr/data/15048740/fileData.do?recommendDataYn=Y