package com.toshiro.weatherapp.di.component

import com.toshiro.weatherapp.WeatherApplication
import com.toshiro.weatherapp.di.module.AppModule
import com.toshiro.weatherapp.di.module.RetrofitModule
import dagger.Component

@Component(modules = [AppModule::class, RetrofitModule::class])
interface ApplicationComponent {
    fun inject(mWeatherApplication: WeatherApplication)
}