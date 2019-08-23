package com.toshiro.weatherapp.utils

class IconWeatherHelper {
    companion object {
        fun setIconWeather(code: Int): String {

            when (code) {
                in 200..2002 -> {
                    //Thunderstorm, rain
                    return "4792-weather-stormshowersday.json"
                }
                in 230..233 -> {
//                    Thunderstorm, drizzle
                    return "4805-weather-thunder.json"
                }
                in 300..302 -> {
                    //Drizzle
                    return "4801-weather-partly-shower.json"
                }
                in 500..522 -> {
                    // rain
                    return "4803-weather-storm.json"

                }
                in 600..610 -> {
                    // snow
                    return "4793-weather-snow.json"
                }
                in 611..612 -> {
                    // sleet
                    return "4798-weather-snownight.json"
                }

                in 621..622 -> {
                    return "4797-weather-rainynight.json"
                }
                623 -> {
                    return "4801-weather-partly-shower.json"
                }
                700 -> {
                    return "4791-foggy.json"
                }
                711 -> {
                    //Smoke
                    return "4795-weather-mist.json"
                }
                721 -> {
                    //Haze
                    return "4795-weather-mist.json"
                }
                731 -> {
                    //sand,dust
                    return "4806-weather-windy.json"
                }
                in 741..751 -> {
                    //frog
                    return "4795-weather-mist.json"
                }
                in 800..802 -> {
                    //clear sky sun
                    return "4793-weather-snow.json"
                }
                803 -> {
                    return "4795-weather-mist.json"
                }
                804 -> {
                    return "4806-weather-windy.json"
                }
                900 -> {
                    return "4796-weather-cloudynight.json"
                }
                else -> {
                    return "4796-weather-cloudynight.json"
                }
            }
        }
    }
}