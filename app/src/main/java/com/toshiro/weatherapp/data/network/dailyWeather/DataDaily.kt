package com.toshiro.weatherapp.data.network.dailyWeather


import com.google.gson.annotations.SerializedName
import com.toshiro.weatherapp.data.network.Weather

data class DataDaily(
    @SerializedName("app_max_temp")
    val appMaxTemp: Double,
    @SerializedName("app_min_temp")
    val appMinTemp: Double,
    @SerializedName("clouds")
    val clouds: Double,
    @SerializedName("clouds_hi")
    val cloudsHi: Double,
    @SerializedName("clouds_low")
    val cloudsLow: Double,
    @SerializedName("clouds_mid")
    val cloudsMid: Double,
    @SerializedName("datetime")
    val datetime: String,
    @SerializedName("dewpt")
    val dewpt: Double,
    @SerializedName("max_dhi")
    val maxDhi: Any,
    @SerializedName("max_temp")
    val maxTemp: Double,
    @SerializedName("min_temp")
    val minTemp: Double,
    @SerializedName("moon_phase")
    val moonPhase: Double,
    @SerializedName("moonrise_ts")
    val moonriseTs: Double,
    @SerializedName("moonset_ts")
    val moonsetTs: Double,
    @SerializedName("ozone")
    val ozone: Double,
    @SerializedName("pop")
    val pop: Double,
    @SerializedName("precip")
    val precip: Double,
    @SerializedName("pres")
    val pres: Double,
    @SerializedName("rh")
    val rh: Double,
    @SerializedName("slp")
    val slp: Double,
    @SerializedName("snow")
    val snow: Double,
    @SerializedName("snow_depth")
    val snowDepth: Double,
    @SerializedName("sunrise_ts")
    val sunriseTs: Double,
    @SerializedName("sunset_ts")
    val sunsetTs: Double,
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("ts")
    val ts: Double,
    @SerializedName("uv")
    val uv: Double,
    @SerializedName("valid_date")
    val validDate: String,
    @SerializedName("vis")
    val vis: Double,
    @SerializedName("weather")
    val weather: Weather,
    @SerializedName("wind_cdir")
    val windCdir: String,
    @SerializedName("wind_cdir_full")
    val windCdirFull: String,
    @SerializedName("wind_dir")
    val windDir: Double,
    @SerializedName("wind_gust_spd")
    val windGustSpd: Double,
    @SerializedName("wind_spd")
    val windSpd: Double
)