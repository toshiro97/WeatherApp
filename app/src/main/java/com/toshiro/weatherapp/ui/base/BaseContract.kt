package com.toshiro.weatherapp.ui.base

class BaseContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun loadError(e: Throwable)
        fun loadError(msg: String)
    }

    interface Presenter {

    }
}