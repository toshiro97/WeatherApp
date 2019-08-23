package com.toshiro.weatherapp.data.network.historicalWeather


import com.google.gson.annotations.SerializedName

data class DataHistorical(
    @SerializedName("clouds")
    val clouds: Int,
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
    @SerializedName("max_dhi")
    val maxDhi: Double,
    @SerializedName("max_dni")
    val maxDni: Double,
    @SerializedName("max_ghi")
    val maxGhi: Double,
    @SerializedName("max_temp")
    val maxTemp: Int,
    @SerializedName("max_temp_ts")
    val maxTempTs: Int,
    @SerializedName("max_uv")
    val maxUv: Double,
    @SerializedName("max_wind_dir")
    val maxWindDir: Int,
    @SerializedName("max_wind_spd")
    val maxWindSpd: Double,
    @SerializedName("max_wind_spd_ts")
    val maxWindSpdTs: Int,
    @SerializedName("min_temp")
    val minTemp: Int,
    @SerializedName("min_temp_ts")
    val minTempTs: Int,
    @SerializedName("precip")
    val precip: Double,
    @SerializedName("precip_gpm")
    val precipGpm: Int,
    @SerializedName("pres")
    val pres: Int,
    @SerializedName("rh")
    val rh: Double,
    @SerializedName("slp")
    val slp: Int,
    @SerializedName("snow")
    val snow: Int,
    @SerializedName("snow_depth")
    val snowDepth: Any,
    @SerializedName("solar_rad")
    val solarRad: Double,
    @SerializedName("t_dhi")
    val tDhi: Double,
    @SerializedName("t_dni")
    val tDni: Double,
    @SerializedName("t_ghi")
    val tGhi: Double,
    @SerializedName("t_solar_rad")
    val tSolarRad: Double,
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("ts")
    val ts: Int,
    @SerializedName("wind_dir")
    val windDir: Int,
    @SerializedName("wind_gust_spd")
    val windGustSpd: Double,
    @SerializedName("wind_spd")
    val windSpd: Double
)