package com.toshiro.weatherapp.ui.weather


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.toshiro.weatherapp.R
import com.toshiro.weatherapp.data.database.AppDatabase
import com.toshiro.weatherapp.data.local.WeatherData
import com.toshiro.weatherapp.ui.base.BaseFragment
import kotlinx.android.synthetic.main.layout_sun.view.*
import kotlinx.android.synthetic.main.layout_temperature_status.*

class WeatherFragment : BaseFragment(), WeatherContract.View {

    private var data: WeatherData? = null
    private  var weatherPresenter: WeatherPresenter ?= null
    private var appDatabase: AppDatabase ?= null


    override fun showAllData(weatherData: WeatherData) {

        data = weatherData

        tvTemperature.text = data!!.feel_temp.toString()
    }


    override fun setUpView(view: View) {
        getPresenter().getAndConverterData("", 105.7934252, 21.0376641)
//        view.sunInDay.updateTime("06:00", "18:00", "09:18")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_weather, container, false)
        appDatabase = AppDatabase.getAppDataBase(context!!)

        return view
    }

    private fun getPresenter(): WeatherPresenter {
        weatherPresenter = WeatherPresenter(this, activity!!.application)
        return weatherPresenter!!
    }

    override fun onStop() {
        super.onStop()
        weatherPresenter?.let {
            weatherPresenter!!.unbindView()
            weatherPresenter = null
        }
    }


}
