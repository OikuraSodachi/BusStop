package com.todokanai.busstop.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.todokanai.busstop.room.retrofitdata.Station
import com.todokanai.busstop.room.retrofitdata.StationDao

@Database(entities = [User::class, Station::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase(){

    abstract fun userDao() : UserDao

    abstract fun stationDao() : StationDao

    companion object {
        private var instance: MyDatabase? = null

        @Synchronized
        fun getInstance(context: Context): MyDatabase {
            if (instance == null) {
                synchronized(MyDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MyDatabase::class.java,
                        "room_db",
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return instance!!
        }
    }
}