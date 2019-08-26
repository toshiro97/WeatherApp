package com.toshiro.weatherapp.ui.home

import com.toshiro.weatherapp.data.database.AppDatabase
import com.toshiro.weatherapp.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler


class HomePresent(var homeView: HomeContract.View) :
    HomeContract.Presenter, BasePresenter<HomeContract.View>(homeView) {


    private var appDatabase: AppDatabase = AppDatabase.INSTANCE!!

    override fun getDataFromDatabase() {

        addDisposable(appDatabase.weatherDao().loadAllWeather().subscribeOn(IoScheduler()).observeOn(
            AndroidSchedulers.mainThread()
        )
            .subscribe(
                { result ->
                    view!!.let {
                        homeView.showFragment(result)

                    }
                },
                { error ->
                    view!!.loadError(error)
                }
            ))

    }

}