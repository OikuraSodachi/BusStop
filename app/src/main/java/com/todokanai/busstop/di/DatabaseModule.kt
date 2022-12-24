package com.todokanai.busstop.di

import android.content.Context
import com.todokanai.busstop.room.UserDao
import com.todokanai.busstop.room.MyDatabase
import com.todokanai.busstop.room.StationDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideUserDatabase(@ApplicationContext context: Context) : MyDatabase {
        return MyDatabase.getInstance(context)
    }

    @Provides
    fun provideUserDao(myDatabase: MyDatabase): UserDao {
        return myDatabase.userDao()
    }

    @Provides
    fun provideStationDao(myDatabase: MyDatabase): StationDao {
        return myDatabase.stationDao()
    }
}