package com.toshiro.weatherapp.data.network.dailyWeather


import com.google.gson.annotations.SerializedName
import com.toshiro.weatherapp.data.network.Weather

data class DataDaily(
    @SerializedName("app_max_temp")
    val appMaxTemp: Number,
    @SerializedName("app_min_temp")
    val appMinTemp: Number,
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
    @SerializedName("max_dhi")
    val maxDhi: Any,
    @SerializedName("max_temp")
    val maxTemp: Number,
    @SerializedName("min_temp")
    val minTemp: Number,
    @SerializedName("moon_phase")
    val moonPhase: Number,
    @SerializedName("moonrise_ts")
    val moonriseTs: Number,
    @SerializedName("moonset_ts")
    val moonsetTs: Number,
    @SerializedName("ozone")
    val ozone: Number,
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
    @SerializedName("sunrise_ts")
    val sunriseTs: Number,
    @SerializedName("sunset_ts")
    val sunsetTs: Number,
    @SerializedName("temp")
    val temp: Number,
    @SerializedName("ts")
    val ts: Number,
    @SerializedName("uv")
    val uv: Number,
    @SerializedName("valid_date")
    val validDate: String,
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