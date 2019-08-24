package com.toshiro.weatherapp

import android.app.Application
import android.content.Context
import com.toshiro.weatherapp.di.component.ApplicationComponent
import com.toshiro.weatherapp.di.component.DaggerApplicationComponent
import com.toshiro.weatherapp.di.module.RetrofitModule


open class WeatherApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
            .retrofitModule(RetrofitModule())
            .build()

        applicationComponent.inject(this)
    }
}