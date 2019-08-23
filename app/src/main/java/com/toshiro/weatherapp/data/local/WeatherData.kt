package com.toshiro.weatherapp.data.local

import androidx.room.*
import com.toshiro.weatherapp.data.network.dailyWeather.DataDaily
import com.toshiro.weatherapp.data.network.hourlyWeather.DataHourly

@Entity(tableName = "WeatherBit")
data class WeatherData(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "imageURL")
    var image_url: String,

    @ColumnInfo(name = "temp")
    var temp: Double,

    @ColumnInfo(name = "maxTemp")
    var max_temp: Double,

    @ColumnInfo(name = "minTemp")
    var min_temp: Double,

    @ColumnInfo(name = "date")
    var date: String,

    @Embedded
    var locationWeather: LocationWeather,

    @ColumnInfo(name = "statusSky")
    var status_sky: String,

    @ColumnInfo(name = "descriptionWeather")
    var description_weather: String,

    @ColumnInfo(name = "hourlyList")
    @TypeConverters(DataHourlyConverter::class)
    var list_hourly: MutableList<DataHourly>,

    @ColumnInfo(name = "feelTemp")
    var feel_temp: String,

    @ColumnInfo(name = "relativeHumidity ")
    var rh: Int,

    @ColumnInfo(name = "uv")
    var uv: Int,

    @ColumnInfo(name = "visibility")
    var visibility: Int,

    @ColumnInfo(name = "dewpt")
    var dewpt: Double,

    @ColumnInfo(name = "pres")
    var pres: Double,

    @ColumnInfo(name = "dailyList")
    @TypeConverters(DataDailyConverter::class)
    var list_daily: MutableList<DataDaily>,

    @ColumnInfo(name = "airIndicator")
    var air_indicator: Int,

    @ColumnInfo(name = "sunrise")
    var sunrise: String,

    @ColumnInfo(name = "sunset")
    var sunset: String,

    @ColumnInfo(name = "percentMoon")
    var percent_moon: Double,

    @ColumnInfo(name = "windSpeed")
    var wind_speed: Double,

    @ColumnInfo(name = "windDirection")
    var wind_direction: String


) {
}