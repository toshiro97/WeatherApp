package com.toshiro.weatherapp.ui.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.toshiro.weatherapp.data.network.currentWeather.DataCurrent

class HomePagerAdapter(fragmentManager: FragmentManager, context: Context) : FragmentPagerAdapter(fragmentManager) {

    private val mFragmentList = mutableListOf<Fragment>()
    private val mFragmentWeatherList = mutableListOf<DataCurrent>()

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    fun addFragment(fragment: Fragment, dataWeatherBit: DataCurrent) {
        mFragmentList.add(fragment)
        mFragmentWeatherList.add(dataWeatherBit)
    }

    fun getPageData(position: Int): DataCurrent {
        return mFragmentWeatherList[position]
    }
}