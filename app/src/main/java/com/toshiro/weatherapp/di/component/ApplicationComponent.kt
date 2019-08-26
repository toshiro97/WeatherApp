package com.toshiro.weatherapp.di.component

import android.content.Context
import com.toshiro.weatherapp.WeatherApplication
import com.toshiro.weatherapp.di.module.AppModule
import com.toshiro.weatherapp.di.module.RetrofitModule
import com.toshiro.weatherapp.ui.home.HomePresent
import com.toshiro.weatherapp.ui.weather.WeatherPresenter
import dagger.Component

@Component(modules = [AppModule::class, RetrofitModule::class])
interface ApplicationComponent {

    fun inject(mWeatherApplication: WeatherApplication)
    fun inject(mHomePresent: HomePresent)
    fun inject(mWeatherPresenter: WeatherPresenter)

}