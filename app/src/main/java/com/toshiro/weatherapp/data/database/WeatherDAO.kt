package com.toshiro.weatherapp.data.database

import androidx.room.*
import com.toshiro.weatherapp.data.local.WeatherData


interface WeatherDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeather(data: WeatherData)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateWeather(data: WeatherData)

    @Delete()
    fun deleteWeather(vararg data: WeatherData)

    @Query("SELECT * FROM weather")
    fun loadAllWeather(): Array<WeatherData>
}