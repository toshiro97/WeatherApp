package com.toshiro.weatherapp.data.network.currentWeather


import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import com.toshiro.weatherapp.data.network.Weather


data class DataCurrent(
    @SerializedName("app_temp")
    val appTemp: Number,
    @SerializedName("aqi")
    val aqi: Number,
    @SerializedName("city_name")
    val cityName: String,
    @SerializedName("clouds")
    val clouds: Number,
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("datetime")
    val datetime: String,
    @SerializedName("dewpt")
    val dewpt: Number,
    @SerializedName("dhi")
    val dhi: Number,
    @SerializedName("dni")
    val dni: Number,
    @SerializedName("elev_angle")
    val elevAngle: Number,
    @SerializedName("ghi")
    val ghi: Number,
    @SerializedName("h_angle")
    val hAngle: Number,
    @SerializedName("last_ob_time")
    val lastObTime: String,
    @SerializedName("lat")
    val lat: Number,
    @SerializedName("lon")
    val lon: Number,
    @SerializedName("ob_time")
    val obTime: String,
    @SerializedName("pod")
    val pod: String,
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
    @SerializedName("solar_rad")
    val solarRad: Number,
    @SerializedName("state_code")
    val stateCode: String,
    @SerializedName("station")
    val station: String,
    @SerializedName("sunrise")
    val sunrise: String,
    @SerializedName("sunset")
    val sunset: String,
    @SerializedName("temp")
    val temp: Number,
    @SerializedName("timezone")
    val timezone: String,
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
    @SerializedName("wind_spd")
    val windSpd: Number
)