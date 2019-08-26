package com.toshiro.weatherapp.ui.weather

import com.toshiro.weatherapp.data.local.WeatherData
import com.toshiro.weatherapp.ui.base.BaseContract

class WeatherContract {
    interface View : BaseContract.View {
        fun showAllData(weatherData: WeatherData)
    }

    interface Presenter {
        fun getAndConverterData(city: String, lat: Double, long: Double)
    }
}