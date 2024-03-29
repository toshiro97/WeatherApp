package com.toshiro.weatherapp.data.network.hourlyWeather


import com.google.gson.annotations.SerializedName

data class ResponseHourly(
    @SerializedName("data")
    val `data`: List<DataHourly>,
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