package com.toshiro.weatherapp.network

import com.toshiro.weatherapp.data.network.currentWeather.ResponseCurrent
import com.toshiro.weatherapp.utils.Constant
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface APIInterface {
    @GET(EndPoints.current)
    fun getCurrentWeather(
        @Query("key") key: String,
        @Query("lat") lat: Double,
        @Query("long") long: Double,
        @Query("city") city: String
    ): Observable<ResponseCurrent>


}