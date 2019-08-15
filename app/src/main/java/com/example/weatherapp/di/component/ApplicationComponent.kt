package com.example.weatherapp.di.component

import com.example.weatherapp.WeatherApplication
import com.example.weatherapp.di.module.AppModule
import com.example.weatherapp.di.module.RetrofitModule
import dagger.Component

@Component(modules = [AppModule::class, RetrofitModule::class])
interface ApplicationComponent {
    fun inject(mWeatherApplication: WeatherApplication)
}