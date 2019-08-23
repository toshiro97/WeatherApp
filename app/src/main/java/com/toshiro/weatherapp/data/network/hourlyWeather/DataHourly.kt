package com.toshiro.weatherapp.data.network.hourlyWeather


import com.google.gson.annotations.SerializedName
import com.toshiro.weatherapp.data.network.Weather

data class DataHourly(
    @SerializedName("app_temp")
    val appTemp: Double,
    @SerializedName("clouds")
    val clouds: Int,
    @SerializedName("clouds_hi")
    val cloudsHi: Int,
    @SerializedName("clouds_low")
    val cloudsLow: Int,
    @SerializedName("clouds_mid")
    val cloudsMid: Int,
    @SerializedName("datetime")
    val datetime: String,
    @SerializedName("dewpt")
    val dewpt: Double,
    @SerializedName("dhi")
    val dhi: Double,
    @SerializedName("dni")
    val dni: Double,
    @SerializedName("ghi")
    val ghi: Double,
    @SerializedName("ozone")
    val ozone: Double,
    @SerializedName("pod")
    val pod: String,
    @SerializedName("pop")
    val pop: Int,
    @SerializedName("precip")
    val precip: Double,
    @SerializedName("pres")
    val pres: Double,
    @SerializedName("rh")
    val rh: Int,
    @SerializedName("slp")
    val slp: Double,
    @SerializedName("snow")
    val snow: Int,
    @SerializedName("snow_depth")
    val snowDepth: Int,
    @SerializedName("solar_rad")
    val solarRad: Double,
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("timestamp_local")
    val timestampLocal: String,
    @SerializedName("timestamp_utc")
    val timestampUtc: String,
    @SerializedName("ts")
    val ts: Int,
    @SerializedName("uv")
    val uv: Double,
    @SerializedName("vis")
    val vis: Double,
    @SerializedName("weather")
    val weather: Weather,
    @SerializedName("wind_cdir")
    val windCdir: String,
    @SerializedName("wind_cdir_full")
    val windCdirFull: String,
    @SerializedName("wind_dir")
    val windDir: Int,
    @SerializedName("wind_gust_spd")
    val windGustSpd: Double,
    @SerializedName("wind_spd")
    val windSpd: Double
)