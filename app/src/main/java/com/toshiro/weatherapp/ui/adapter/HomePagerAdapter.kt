package com.toshiro.weatherapp.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.toshiro.weatherapp.data.local.WeatherData
import com.toshiro.weatherapp.ui.weather.WeatherFragment


class HomePagerAdapter(
    fragmentManager: FragmentManager,
    private val mFragmentWeatherList: List<WeatherData>
) : FragmentStatePagerAdapter(
    fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {



    override fun getItem(position: Int): Fragment {
        return WeatherFragment()
    }

    override fun getCount(): Int {
        return if (mFragmentWeatherList.isNotEmpty())
            mFragmentWeatherList.size
        else
            1
    }

}