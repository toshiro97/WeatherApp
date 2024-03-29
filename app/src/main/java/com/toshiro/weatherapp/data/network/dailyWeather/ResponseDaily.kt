package com.toshiro.weatherapp.data.network.dailyWeather


import com.google.gson.annotations.SerializedName

data class ResponseDaily(
    @SerializedName("data")
    val `data`: List<DataDaily>,
    @SerializedName("city_name")
    val cityName: String,
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("lat")
    val lat: String,
    @SerializedName("lon")
    val lon: String,
    @SerializedName("state_code")
    val stateCode: String,
    @SerializedName("timezone")
    val timezone: String
)