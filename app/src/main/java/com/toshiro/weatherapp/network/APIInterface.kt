package com.toshiro.weatherapp.network

import com.toshiro.weatherapp.data.network.currentWeather.ResponseCurrent
import com.toshiro.weatherapp.data.network.dailyWeather.ResponseDaily
import com.toshiro.weatherapp.data.network.hourlyWeather.ResponseHourly
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface APIInterface {
    @GET(EndPoints.current)
    fun getCurrentWeather(
        @Query("key") key: String,
        @Query("city") city: String,
        @Query("lat") lat: Double,
        @Query("lon") long: Double
    ): Observable<ResponseCurrent>

    @GET(EndPoints.daily)
    fun getDailyWeather(
        @Query("key") key: String,
        @Query("city") city: String,
        @Query("days") day: Int,
        @Query("lat") lat: Double,
        @Query("lon") long: Double
    ): Observable<ResponseDaily>


    @GET(EndPoints.hourly)
    fun getHourlyWeather(
        @Query("key") key: String,
        @Query("city") city: String,
        @Query("hours") hour: Int,
        @Query("lat") lat: Double,
        @Query("lon") long: Double
    ) :Observable<ResponseHourly>
}