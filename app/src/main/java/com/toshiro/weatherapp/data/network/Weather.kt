package com.toshiro.weatherapp.data.network


import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class Weather(
    @ColumnInfo(name = "code")
    @SerializedName("code")
    val code: String,

    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description: String,

    @ColumnInfo(name = "icon")
    @SerializedName("icon")
    val icon: String
)