package com.toshiro.weatherapp.utils

import android.content.res.Resources
import android.location.Location
import com.toshiro.weatherapp.R
import com.toshiro.weatherapp.data.local.WeatherData
import com.toshiro.weatherapp.data.network.currentWeather.DataCurrent
import com.toshiro.weatherapp.data.network.dailyWeather.DataDaily
import com.toshiro.weatherapp.data.network.historicalWeather.DataHistorical
import com.toshiro.weatherapp.data.network.hourlyWeather.DataHourly

class DataWeatherHelper {

    companion object {
        lateinit var data: WeatherData


        fun convertWeatherBit(
            dataCurrent: DataCurrent,
            dataDaily: DataDaily,
            dataHistorical: DataHistorical,
            dataHourly: DataHourly,
            location: Location
        ): WeatherData {
            data.image_url = ""
            data.temp = dataCurrent.temp
            data.max_temp = dataDaily.maxTemp
            data.min_temp = dataDaily.minTemp
            data.date = DateHelper.getDate()
            data.locationWeather.lat = location.latitude
            data.locationWeather.long = location.longitude
            data.status_sky = formatStatusSky(dataCurrent.clouds)
            data.description_weather =


                return data

        }

        private fun formatStatusSky(clouds: Int): String {
            return when (clouds) {
                in 0..50 -> {
                    Resources.getSystem().getString(R.string.cloud_little)
                }
                else -> {
                    Resources.getSystem().getString(R.string.cloud_much)
                }
            }
        }

        private fun formatDescriptionSky(): String {
            return "${Resources.getSystem().getString(R.string.today)} - "
        }

        private fun formatStatusWeather(code : Int) : String{
            when (code) {
                in 200..2002 -> {
                    //Thunderstorm, rain
                    return Resources.getSystem().getString(R.string.thunderstorm_rain)
                }
                in 230..233 -> {
//                    Thunderstorm, drizzle
                    return Resources.getSystem().getString(R.string.thunderstorm_drizzle)
                }
                in 300..302 -> {
                    //Drizzle
                    return Resources.getSystem().getString(R.string.drizzle)
                }
                in 500..522 -> {
                    // rain
                    return Resources.getSystem().getString(R.string.rain)

                }
                in 600..610 -> {
                    // snow
                    return Resources.getSystem().getString(R.string.snow)
                }
                in 611..612 -> {
                    // sleet
                    return Resources.getSystem().getString(R.string.sleet)
                }

                in 621..622 -> {
                    return Resources.getSystem().getString(R.string.snow_shower)
                }
                623 -> {
                    return Resources.getSystem().getString(R.string.flurries)
                }
                700 -> {
                    return Resources.getSystem().getString(R.string.mist)
                }
                711 -> {
                    //Smoke
                    return Resources.getSystem().getString(R.string.smoke)
                }
                721 -> {
                    //Haze
                    return Resources.getSystem().getString(R.string.haze)
                }
                731 -> {
                    //sand,dust
                    return Resources.getSystem().getString(R.string.sand_dust)
                }
                in 741..751 -> {
                    //frog
                    return Resources.getSystem().getString(R.string.frog)
                }
                in 800..802 -> {
                    //clear sky sun
                    return Resources.getSystem().getString(R.string.clear_sky)
                }
                803 -> {
                    return Resources.getSystem().getString(R.string.broken_clounds)
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