package com.toshiro.weatherapp.ui.home

import android.app.Application
import com.toshiro.weatherapp.WeatherApplication
import com.toshiro.weatherapp.network.APIInterface
import com.toshiro.weatherapp.ui.base.BasePresenter
import javax.inject.Inject

class HomePresent(var homeView: HomeContract.View, applicationComponent: Application) :
    HomeContract.Presenter, BasePresenter<HomeContract.View>(homeView) {

    @Inject
    lateinit var mNetworkApi: APIInterface

    init {
        (applicationComponent as WeatherApplication).applicationComponent.inject(this)
    }

    override fun getAndConverterData() {

    }

}