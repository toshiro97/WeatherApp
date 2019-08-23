package com.toshiro.weatherapp.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.toshiro.weatherapp.data.network.hourlyWeather.DataHourly
import java.util.*

class DataHourlyConverter {
    var gson = Gson()

    @TypeConverter
    fun fromHourlyList(data: String?): MutableList<DataHourly>? {

        if (data == null){
            return Collections.emptyList()
        }
        val listType = object : TypeToken<MutableList<String>>() {}.type
        return gson.fromJson(data, listType)

    }

    @TypeConverter
    fun listHourlyToString(listHourly: MutableList<DataHourly>?): String? {
        return gson.toJson(listHourly)
    }

}