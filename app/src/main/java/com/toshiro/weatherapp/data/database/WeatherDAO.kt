package com.toshiro.weatherapp.data.database

import androidx.room.*
import com.toshiro.weatherapp.data.local.WeatherData
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single


@Dao
interface WeatherDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeather(data: WeatherData): Single<Long>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateWeather(data: WeatherData): Single<Int>

    @Delete()
    fun deleteWeather(vararg data: WeatherData): Single<Int>

    @Query("SELECT * FROM WeatherBit")
    fun loadAllWeather(): Flowable<List<WeatherData>>
}