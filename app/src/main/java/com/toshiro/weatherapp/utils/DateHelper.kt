package com.toshiro.weatherapp.utils

import java.text.SimpleDateFormat
import java.util.*

class DateHelper {
    companion object {
        fun formatDateToDayOfWeek(date: String): String {
            val language = Locale.getDefault().displayLanguage
            val country = Locale.getDefault().country

            val sdfIn = SimpleDateFormat("yyyy-MM-dd")
            val sdfOut = SimpleDateFormat("EEE", Locale(language, country))
            val input = "2017-07-25"
            val date = sdfIn.parse(input)

            return sdfOut.format(date)
        }

        fun formatTimeUTC(time: String): String {
            val utcFormat = SimpleDateFormat("HH:mm")
            utcFormat.timeZone = TimeZone.getTimeZone("UTC")

            val date = utcFormat.parse(time)

            val defaultFormat = SimpleDateFormat("HH:mm")
            defaultFormat.timeZone = TimeZone.getDefault()

            return defaultFormat.format(date)
        }

        fun getDate(): String {
            val date = Date()
            val language = Locale.getDefault().language
            val country = Locale.getDefault().country
            val formatDate = SimpleDateFormat(
                "EEE, dd  MMMM ",
                Locale(language, country)
            )

            return formatDate.format(date)
        }
    }
}
