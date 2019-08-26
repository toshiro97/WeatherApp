package com.toshiro.weatherapp.utils

import android.content.Context
import com.toshiro.weatherapp.R
import com.toshiro.weatherapp.WeatherApplication
import com.toshiro.weatherapp.data.local.LocationWeather
import com.toshiro.weatherapp.data.local.WeatherData
import com.toshiro.weatherapp.data.network.currentWeather.DataCurrent
import com.toshiro.weatherapp.data.network.dailyWeather.DataDaily
import com.toshiro.weatherapp.data.network.hourlyWeather.DataHourly


class DataWeatherHelper(var context: Context) {

    companion object {


        fun convertWeatherBit(
            dataCurrent: DataCurrent,
            dataDaily: List<DataDaily>,
            dataHourly: List<DataHourly>,
            location: LocationWeather
        ): WeatherData {
            val data: WeatherData? = WeatherData()

            data!!.image_url = ""
            data.temp = dataCurrent.temp
            data.max_temp = dataDaily[0].maxTemp
            data.min_temp = dataDaily[0].minTemp
            data.date = DateHelper.getDate()
            data.locationWeather = location

            data.status_sky = formatStatusSky(dataCurrent.clouds)
            data.description_weather =
                formatDescriptionSky(
                    dataDaily[0].weather.code,
                    dataDaily[0].maxTemp,
                    dataDaily[0].minTemp,
                    dataDaily[0].windCdir,
                    dataDaily[0].windSpd,
                    dataDaily[0].pop
                )
            data.list_hourly = dataHourly
            data.feel_temp = dataCurrent.temp
            data.rh = dataCurrent.rh
            data.uv = dataCurrent.uv
            data.visibility = dataCurrent.vis
            data.dewpt = dataCurrent.dewpt
            data.pres = dataCurrent.pres
            data.list_daily = dataDaily
            data.air_indicator = dataCurrent.aqi
            data.sunrise = dataCurrent.sunrise
            data.sunset = dataCurrent.sunset
            data.percent_moon = dataDaily[0].moonPhase
            data.wind_speed = dataCurrent.windSpd
            data.wind_direction = dataCurrent.windCdir


            return data

        }

        private fun formatStatusSky(clouds: Double): String {
            return when (clouds.toInt()) {
                in 0..50 -> {

                    WeatherApplication.res.getString(R.string.cloud_little)
                }
                else -> {
                    WeatherApplication.res.getString(R.string.cloud_much)
                }
            }
        }

        private fun formatDescriptionSky(
            codeWeather: String,
            maxTemp: Double,
            minTemp: Double,
            windDirection: String,
            windSpeed: Double,
            pop: Double
        ): String {
            return "${WeatherApplication.res.getString(R.string.today)} - ${formatStatusWeather(
                codeWeather
            )}. ${WeatherApplication.res.getString(R.string.hight)} $maxTemp${WeatherApplication.res.getString(
                R.string.celsius
            )}, ${WeatherApplication.res.getString(R.string.low)} $minTemp${WeatherApplication.res.getString(
                R.string.celsius
            )}. ${WeatherApplication.res.getString(R.string.wind)} - ${formatWindDirection(
                windDirection
            )}, ${WeatherApplication.res.getString(R.string.speed)} $windSpeed ${WeatherApplication.res.getString(
                R.string.km_per_hour
            )}. ${WeatherApplication.res.getString(R.string.ability_to_rain)} $pop%  "
        }

        private fun formatStatusWeather(code: String): String {
            when (code.toInt()) {
                in 200..2002 -> {
                    //Thunderstorm, rain
                    return WeatherApplication.res.getString(R.string.thunderstorm_rain)
                }
                in 230..233 -> {
//                    Thunderstorm, drizzle
                    return WeatherApplication.res.getString(R.string.thunderstorm_drizzle)
                }
                in 300..302 -> {
                    //Drizzle
                    return WeatherApplication.res.getString(R.string.drizzle)
                }
                in 500..522 -> {
                    // rain
                    return WeatherApplication.res.getString(R.string.rain)

                }
                in 600..610 -> {
                    // snow
                    return WeatherApplication.res.getString(R.string.snow)
                }
                in 611..612 -> {
                    // sleet
                    return WeatherApplication.res.getString(R.string.sleet)
                }

                in 621..622 -> {
                    return WeatherApplication.res.getString(R.string.snow_shower)
                }
                623 -> {
                    return WeatherApplication.res.getString(R.string.flurries)
                }
                700 -> {
                    return WeatherApplication.res.getString(R.string.mist)
                }
                711 -> {
                    //Smoke
                    return WeatherApplication.res.getString(R.string.smoke)
                }
                721 -> {
                    //Haze
                    return WeatherApplication.res.getString(R.string.haze)
                }
                731 -> {
                    //sand,dust
                    return WeatherApplication.res.getString(R.string.sand_dust)
                }
                in 741..751 -> {
                    //frog
                    return WeatherApplication.res.getString(R.string.frog)
                }
                in 800..802 -> {
                    //clear sky sun
                    return WeatherApplication.res.getString(R.string.clear_sky)
                }
                803 -> {
                    return WeatherApplication.res.getString(R.string.broken_clounds)
                }
                804 -> {
                    return WeatherApplication.res.getString(R.string.overcast_clouds)
                }
                else -> {
                    return WeatherApplication.res.getString(R.string.unknown_precipitation)
                }

            }
        }

        private fun formatWindDirection(windDirection: String): String {
            when (windDirection) {
                "N" -> {
                    return WeatherApplication.res.getString(R.string.north)
                }
                "NNE" -> {
                    return WeatherApplication.res.getString(R.string.north_north_east)
                }
                "NE" -> {
                    return WeatherApplication.res.getString(R.string.north_east)
                }
                "ENE" -> {
                    return WeatherApplication.res.getString(R.string.east_north_east)
                }
                "E" -> {
                    return WeatherApplication.res.getString(R.string.east)
                }
                "ESE" -> {
                    return WeatherApplication.res.getString(R.string.east_south_east)
                }
                "SE" -> {
                    return WeatherApplication.res.getString(R.string.south_east)
                }
                "SSE" -> {
                    return WeatherApplication.res.getString(R.string.south_south_east)
                }
                "S" -> {
                    return WeatherApplication.res.getString(R.string.south)
                }
                "SSW" -> {
                    return WeatherApplication.res.getString(R.string.south_south_west)
                }
                "SW" -> {
                    return WeatherApplication.res.getString(R.string.south_west)
                }
                "WSW" -> {
                    return WeatherApplication.res.getString(R.string.west_south_west)
                }
                "W" -> {
                    return WeatherApplication.res.getString(R.string.west)
                }
                "WNW" -> {
                    return WeatherApplication.res.getString(R.string.west_north_west)
                }
                "NW" -> {
                    return WeatherApplication.res.getString(R.string.north_west)
                }
                "NNW" -> {
                    return WeatherApplication.res.getString(R.string.north_north_west)
                }
                else -> {
                    return WeatherApplication.res.getString(R.string.unknow_weather)
                }
            }
        }

    }
}