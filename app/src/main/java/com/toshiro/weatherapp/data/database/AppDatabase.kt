package com.toshiro.weatherapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.toshiro.weatherapp.data.local.DataDailyConverter
import com.toshiro.weatherapp.data.local.DataHourlyConverter
import com.toshiro.weatherapp.data.local.WeatherData


@Database(entities = [WeatherData::class], version = 1, exportSchema = false)
@TypeConverters(DataDailyConverter::class, DataHourlyConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDAO

    companion object {
        var INSTANCE: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "WeatherBit"
                    ).build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase() {
            INSTANCE = null
        }
    }
}