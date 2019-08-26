package com.toshiro.weatherapp.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.toshiro.weatherapp.data.network.dailyWeather.DataDaily
import java.util.*

class DataDailyConverter {

    var gson = Gson()

    @TypeConverter
    fun fromDailyList(data: String?): List<DataDaily>? {

        if (data == null){
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(data, listType)

    }

    @TypeConverter
    fun listDailyToString(listHourly: List<DataDaily>?): String? {
        return gson.toJson(listHourly)
    }

}