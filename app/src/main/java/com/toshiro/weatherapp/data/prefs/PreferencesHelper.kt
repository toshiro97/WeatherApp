package com.toshiro.weatherapp.data.prefs

interface PreferencesHelper {
    fun isFirstTime(): Boolean

    fun setFirstTime(firstTime: Boolean)

    fun setUser(user: String)

    fun getUser(): String


}