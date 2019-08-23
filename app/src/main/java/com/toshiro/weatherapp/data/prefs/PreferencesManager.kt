package com.toshiro.weatherapp.data.prefs

import android.content.Context
import android.content.SharedPreferences
import com.toshiro.weatherapp.utils.Constant
import com.toshiro.weatherapp.utils.Constant.Companion.PREF_KEY_FIRST_TIME
import com.toshiro.weatherapp.utils.Constant.Companion.PREF_KEY_USER

class PreferencesManager(context: Context) : PreferencesHelper {


    private val mPrefs: SharedPreferences
    private val mAppContext: Context

    init {
        mPrefs = context.getSharedPreferences(Constant.PREF_KEY_FILE, Context.MODE_PRIVATE)
        mAppContext = context
    }

    override fun setFirstTime(firstTime: Boolean) {
        val editor = mPrefs.edit()
        editor.putBoolean(PREF_KEY_FIRST_TIME, firstTime)
        editor.apply()
    }

    override fun isFirstTime(): Boolean {
        return mPrefs.getBoolean(PREF_KEY_FIRST_TIME, true)
    }


    override fun setUser(user: String) {
        val editor = mPrefs.edit()
        editor.putString(PREF_KEY_USER, user)
        editor.apply()
    }

    override fun getUser(): String {
        return mPrefs.getString(PREF_KEY_USER, "")!!
    }
}