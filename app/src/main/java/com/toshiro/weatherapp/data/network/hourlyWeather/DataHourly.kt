package com.toshiro.weatherapp.data.network.hourlyWeather


import com.google.gson.annotations.SerializedName
import com.toshiro.weatherapp.data.network.Weather

data class DataHourly(
    @SerializedName("app_temp")
    val appTemp: Number,
    @SerializedName("clouds")
    val clouds: Number,
    @SerializedName("clouds_hi")
    val cloudsHi: Number,
    @SerializedName("clouds_low")
    val cloudsLow: Number,
    @SerializedName("clouds_mid")
    val cloudsMid: Number,
    @SerializedName("datetime")
    val datetime: String,
    @SerializedName("dewpt")
    val dewpt: Number,
    @SerializedName("dhi")
    val dhi: Number,
    @SerializedName("dni")
    val dni: Number,
    @SerializedName("ghi")
    val ghi: Number,
    @SerializedName("ozone")
    val ozone: Number,
    @SerializedName("pod")
    val pod: String,
    @SerializedName("pop")
    val pop: Number,
    @SerializedName("precip")
    val precip: Number,
    @SerializedName("pres")
    val pres: Number,
    @SerializedName("rh")
    val rh: Number,
    @SerializedName("slp")
    val slp: Number,
    @SerializedName("snow")
    val snow: Number,
    @SerializedName("snow_depth")
    val snowDepth: Number,
    @SerializedName("solar_rad")
    val solarRad: Number,
    @SerializedName("temp")
    val temp: Number,
    @SerializedName("timestamp_local")
    val timestampLocal: String,
    @SerializedName("timestamp_utc")
    val timestampUtc: String,
    @SerializedName("ts")
    val ts: Number,
    @SerializedName("uv")
    val uv: Number,
    @SerializedName("vis")
    val vis: Number,
    @SerializedName("weather")
    val weather: Weather,
    @SerializedName("wind_cdir")
    val windCdir: String,
    @SerializedName("wind_cdir_full")
    val windCdirFull: String,
    @SerializedName("wind_dir")
    val windDir: Number,
    @SerializedName("wind_gust_spd")
    val windGustSpd: Number,
    @SerializedName("wind_spd")
    val windSpd: Number
)