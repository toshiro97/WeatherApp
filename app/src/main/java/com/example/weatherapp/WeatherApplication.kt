package com.example.weatherapp

import android.app.Application
import com.example.weatherapp.di.component.ApplicationComponent
import com.example.weatherapp.di.component.DaggerApplicationComponent
import com.example.weatherapp.di.module.RetrofitModule


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