package com.toshiro.weatherapp.data.local

import androidx.room.ColumnInfo

data class LocationWeather(
    @ColumnInfo(name = "locationName")
    var locationName: String,

    @ColumnInfo(name = "lat")
    var lat: Double,

    @ColumnInfo(name = "long")
    var long: Double
)