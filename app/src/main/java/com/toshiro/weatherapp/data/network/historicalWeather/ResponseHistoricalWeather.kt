package com.toshiro.weatherapp.data.network.historicalWeather


import com.google.gson.annotations.SerializedName

data class ResponseHistoricalWeather(
    @SerializedName("data")
    val `data`: List<DataHistorical>,
    @SerializedName("city_id")
    val cityId: String,
    @SerializedName("city_name")
    val cityName: String,
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("sources")
    val sources: List<String>,
    @SerializedName("state_code")
    val stateCode: String,
    @SerializedName("station_id")
    val stationId: String,
    @SerializedName("timezone")
    val timezone: String
)