package com.toshiro.weatherapp.ui.home

import android.app.Application
import com.toshiro.weatherapp.WeatherApplication
import com.toshiro.weatherapp.data.local.LocationWeather
import com.toshiro.weatherapp.data.network.currentWeather.ResponseCurrent
import com.toshiro.weatherapp.data.network.dailyWeather.ResponseDailyWeather
import com.toshiro.weatherapp.data.network.hourlyWeather.ResponseHourlyWeather
import com.toshiro.weatherapp.network.APIInterface
import com.toshiro.weatherapp.ui.base.BasePresenter
import com.toshiro.weatherapp.utils.Constant
import com.toshiro.weatherapp.utils.DataWeatherHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import javax.inject.Inject

class HomePresent(homeView: HomeContract.View, applicationComponent: Application) :
    HomeContract.Presenter, BasePresenter<HomeContract.View>(homeView) {

    private lateinit var responseHourlyWeather: ResponseHourlyWeather
    private lateinit var responseDailyWeather: ResponseDailyWeather
    private lateinit var responseCurrent: ResponseCurrent
    private var checkCurrent: Boolean = false
    private var checkDaily: Boolean = false
    private var checkHourly: Boolean = false


    @Inject
    lateinit var mNetworkApi: APIInterface

    init {
        (applicationComponent as WeatherApplication).applicationComponent.inject(this)
    }

    override fun getAndConverterData(city: String, lat: Double, long: Double) {
        val location = LocationWeather(city, lat, long)

        val key = Constant.API_KEY_WEATHER_BIT
        val view = view()
        view!!.showLoading()

        val dataCurrent = mNetworkApi.getCurrentWeather(key, city, lat, long)

        val dataDaily = mNetworkApi.getDailyWeather(key, city, 16, lat, long)

        val dataHourly = mNetworkApi.getHourlyWeather(key, city, 24, lat, long)

        addDisposable(dataCurrent.subscribeOn(IoScheduler()).observeOn(AndroidSchedulers.mainThread()).subscribe(
            { result ->
                responseCurrent = result
                checkCurrent = true
                if (checkCurrent && checkDaily && checkHourly) {
                    val data = DataWeatherHelper.convertWeatherBit(
                        responseCurrent.data[0],
                        responseDailyWeather.data,
                        responseHourlyWeather.data,
                        location
                    )
                    view.let {
                        it.showAllData(data)
                        it.hideLoading()
                    }
                }
            },
            { error ->
                view.let {
                    it.hideLoading()
                    it.loadError(error)
                }
            }
        ))

        addDisposable(dataDaily.subscribeOn(IoScheduler()).observeOn(AndroidSchedulers.mainThread()).subscribe(
            { result ->
                responseDailyWeather = result
                checkDaily = true
                if (checkCurrent && checkDaily && checkHourly) {
                    val data = DataWeatherHelper.convertWeatherBit(
                        responseCurrent.data[0],
                        responseDailyWeather.data,
                        responseHourlyWeather.data,
                        location
                    )
                    view.let {
                        it.showAllData(data)
                        it.hideLoading()
                    }
                }
            },
            { error ->
                view.let {
                    it.hideLoading()
                    it.loadError(error)
                }
            }
        ))

        addDisposable(dataHourly.subscribeOn(IoScheduler()).observeOn(AndroidSchedulers.mainThread()).subscribe(
            { result ->
                responseHourlyWeather = result
                checkHourly = true
                if (checkCurrent && checkDaily && checkHourly) {
                    val data = DataWeatherHelper.convertWeatherBit(
                        responseCurrent.data[0],
                        responseDailyWeather.data,
                        responseHourlyWeather.data,
                        location
                    )
                    view.let {
                        it.showAllData(data)
                        it.hideLoading()
                    }
                }
            },
            { error ->
                view.let {
                    it.hideLoading()
                    it.loadError(error)
                }
            }
        ))


    }


}