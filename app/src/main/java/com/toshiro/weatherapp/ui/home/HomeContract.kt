package com.toshiro.weatherapp.ui.home


import com.toshiro.weatherapp.data.local.WeatherData
import com.toshiro.weatherapp.data.network.currentWeather.DataCurrent
import com.toshiro.weatherapp.ui.base.BaseContract

class HomeContract {
    interface View : BaseContract.View {
        fun showAllData(weatherData: WeatherData)
    }

    interface Presenter {
        fun getAndConverterData(city: String, lat: Double, long: Double)
    }
}