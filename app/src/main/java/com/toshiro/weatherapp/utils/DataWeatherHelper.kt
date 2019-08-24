package com.toshiro.weatherapp.utils

import android.content.res.Resources
import android.location.Location
import com.toshiro.weatherapp.R
import com.toshiro.weatherapp.data.local.WeatherData
import com.toshiro.weatherapp.data.network.currentWeather.DataCurrent
import com.toshiro.weatherapp.data.network.dailyWeather.DataDaily
import com.toshiro.weatherapp.data.network.hourlyWeather.DataHourly

class DataWeatherHelper {

    companion object {
        lateinit var data: WeatherData


        fun convertWeatherBit(
            dataCurrent: DataCurrent,
            dataDaily: DataDaily,
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
                formatDescriptionSky(
                    dataDaily.weather.code,
                    dataDaily.maxTemp,
                    dataDaily.minTemp,
                    dataDaily.windCdir,
                    dataDaily.windSpd,
                    dataDaily.pop
                )
            data.list_hourly = mutableListOf(dataHourly)
            data.feel_temp = dataCurrent.temp
            data.rh = dataCurrent.rh
            data.uv = dataCurrent.uv
            data.visibility = dataCurrent.vis
            data.dewpt = dataCurrent.dewpt
            data.pres = dataCurrent.pres
            data.list_daily = mutableListOf(dataDaily)
            data.air_indicator = dataCurrent.aqi
            data.sunrise = dataCurrent.sunrise
            data.sunset = dataCurrent.sunset
            data.percent_moon = dataDaily.moonPhase
            data.wind_speed = dataCurrent.windSpd
            data.wind_direction = dataCurrent.windCdir


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

        private fun formatDescriptionSky(
            codeWeather: String,
            maxTemp: Double,
            minTemp: Double,
            windDirection: String,
            windSpeed: Double,
            pop: Int
        ): String {
            return "${Resources.getSystem().getString(R.string.today)} - ${formatStatusWeather(
                codeWeather
            )}. ${Resources.getSystem().getString(R.string.hight)} $maxTemp${Resources.getSystem().getString(
                R.string.celsius
            )}, ${Resources.getSystem().getString(R.string.low)} $minTemp${Resources.getSystem().getString(
                R.string.celsius
            )}. ${Resources.getSystem().getString(R.string.wind)} - ${formatWindDirection(
                windDirection
            )}, ${Resources.getSystem().getString(R.string.speed)} $windSpeed ${Resources.getSystem().getString(
                R.string.km_per_hour
            )}. ${Resources.getSystem().getString(R.string.ability_to_rain)} $pop%  "
        }

        private fun formatStatusWeather(code: String): String {
            when (code.toInt()) {
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
                    return Resources.getSystem().getString(R.string.overcast_clouds)
                }
                else -> {
                    return Resources.getSystem().getString(R.string.unknown_precipitation)
                }

            }
        }

        private fun formatWindDirection(windDirection: String): String {
            when (windDirection) {
                "N" -> {
                    return Resources.getSystem().getString(R.string.north)
                }
                "NNE" -> {
                    return Resources.getSystem().getString(R.string.north_north_east)
                }
                "NE" -> {
                    return Resources.getSystem().getString(R.string.north_east)
                }
                "ENE" -> {
                    return Resources.getSystem().getString(R.string.east_north_east)
                }
                "E" -> {
                    return Resources.getSystem().getString(R.string.east)
                }
                "ESE" -> {
                    return Resources.getSystem().getString(R.string.east_south_east)
                }
                "SE" -> {
                    return Resources.getSystem().getString(R.string.south_east)
                }
                "SSE" -> {
                    return Resources.getSystem().getString(R.string.south_south_east)
                }
                "S" -> {
                    return Resources.getSystem().getString(R.string.south)
                }
                "SSW" -> {
                    return Resources.getSystem().getString(R.string.south_south_west)
                }
                "SW" -> {
                    return Resources.getSystem().getString(R.string.south_west)
                }
                "WSW" -> {
                    return Resources.getSystem().getString(R.string.west_south_west)
                }
                "W" -> {
                    return Resources.getSystem().getString(R.string.west)
                }
                "WNW" -> {
                    return Resources.getSystem().getString(R.string.west_north_west)
                }
                "NW" -> {
                    return Resources.getSystem().getString(R.string.north_west)
                }
                "NNW" -> {
                    return Resources.getSystem().getString(R.string.north_north_west)
                }
                else -> {
                    return Resources.getSystem().getString(R.string.unknow_weather)
                }
            }
        }

    }
}