package com.toshiro.weatherapp

import android.app.Application
import android.content.res.Resources
import com.toshiro.weatherapp.di.component.ApplicationComponent
import com.toshiro.weatherapp.di.component.DaggerApplicationComponent
import com.toshiro.weatherapp.di.module.RetrofitModule


class WeatherApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent

    companion object {
        lateinit var res: Resources
    }


    override fun onCreate() {
        super.onCreate()
        res = resources
        applicationComponent = DaggerApplicationComponent.builder()
            .retrofitModule(RetrofitModule())
            .build()

        applicationComponent.inject(this)
    }
}