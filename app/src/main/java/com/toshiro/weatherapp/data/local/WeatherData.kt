package com.toshiro.weatherapp.data.local

import androidx.room.*
import com.toshiro.weatherapp.data.network.dailyWeather.DataDaily
import com.toshiro.weatherapp.data.network.hourlyWeather.DataHourly

@Entity(tableName = "WeatherBit")
data class WeatherData(
    @PrimaryKey(autoGenerate = true)
    var id: Number = 0,
    @ColumnInfo(name = "imageURL")
    var image_url: String = "",

    @ColumnInfo(name = "temp")
    var temp: Number = 0,

    @ColumnInfo(name = "maxTemp")
    var max_temp: Number = 0,

    @ColumnInfo(name = "minTemp")
    var min_temp: Number = 0,

    @ColumnInfo(name = "date")
    var date: String = "",

    @Embedded
    var locationWeather: LocationWeather ?= null,

    @ColumnInfo(name = "statusSky")
    var status_sky: String = "",

    @ColumnInfo(name = "descriptionWeather")
    var description_weather: String = "",

    @ColumnInfo(name = "hourlyList")
    @TypeConverters(DataHourlyConverter::class)
    var list_hourly: MutableList<DataHourly>? = null,

    @ColumnInfo(name = "feelTemp")
    var feel_temp: Number = 0,

    @ColumnInfo(name = "relativeHumidity ")
    var rh: Number = 0,

    @ColumnInfo(name = "uv")
    var uv: Number = 0,

    @ColumnInfo(name = "visibility")
    var visibility: Number = 0,

    @ColumnInfo(name = "dewpt")
    var dewpt: Number = 0,

    @ColumnInfo(name = "pres")
    var pres: Number = 0,

    @ColumnInfo(name = "dailyList")
    @TypeConverters(DataDailyConverter::class)
    var list_daily: MutableList<DataDaily>? = null,

    @ColumnInfo(name = "airIndicator")
    var air_indicator: Number = 0,

    @ColumnInfo(name = "sunrise")
    var sunrise: String = "",

    @ColumnInfo(name = "sunset")
    var sunset: String = "",

    @ColumnInfo(name = "percentMoon")
    var percent_moon: Number = 0,

    @ColumnInfo(name = "windSpeed")
    var wind_speed: Number = 0,

    @ColumnInfo(name = "windDirection")
    var wind_direction: String = ""


)