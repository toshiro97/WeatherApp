package com.toshiro.weatherapp.ui.home


import com.toshiro.weatherapp.data.local.WeatherData
import com.toshiro.weatherapp.ui.base.BaseContract

class HomeContract {
    interface View : BaseContract.View {
        fun showFragment(listWeatherData: List<WeatherData>)
    }

    interface Presenter {
        fun getDataFromDatabase()
    }
}