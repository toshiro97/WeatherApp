package com.toshiro.weatherapp.data.network.currentWeather


import com.google.gson.annotations.SerializedName

data class ResponseCurrent(
    @SerializedName("data")
    val `data`: List<DataCurrent>,
    @SerializedName("count")
    val count: Int
)