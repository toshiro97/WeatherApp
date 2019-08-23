package com.toshiro.weatherapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.toshiro.weatherapp.R
import com.toshiro.weatherapp.data.network.halfMonthWeather.DataForeCast
import com.toshiro.weatherapp.utils.DateHelper.Companion.formatDateToDayOfWeek
import com.toshiro.weatherapp.utils.IconWeatherHelper


class SevenNextDayAdapter(private val context: Context, private val listForeCast: MutableList<DataForeCast>) :
    RecyclerView.Adapter<SevenNextDayAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SevenNextDayAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = listForeCast.size

    override fun onBindViewHolder(holder: SevenNextDayAdapter.ViewHolder, position: Int) {
        val foreCast: DataForeCast = listForeCast[position]
        holder.bind(foreCast)
    }


    class ViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.custom_temperature, parent, false)) {

        private var tempProcess: ImageView? = null
        private var tvMaxTemp: TextView? = null
        private var tvMinTemp: TextView? = null
        private var tvHumidity: TextView? = null
        private var lottieIcon: LottieAnimationView? = null
        private var tvDayOfWeek: TextView? = null

        init {
            tvMaxTemp = itemView.findViewById(R.id.tvMaxTemp)
            tvMinTemp = itemView.findViewById(R.id.tvMinTemp)
            tempProcess = itemView.findViewById(R.id.templeView)
            tvHumidity = itemView.findViewById(R.id.tvHumidity)
            lottieIcon = itemView.findViewById(R.id.lottieIcon)
            tvDayOfWeek = itemView.findViewById(R.id.tvDayOfWeek)
        }

        fun bind(dataForeCast: DataForeCast) {
            tvMaxTemp!!.text = dataForeCast.maxTemp.toString()
            tvMinTemp!!.text = dataForeCast.minTemp.toString()
            tvHumidity!!.text = dataForeCast.rh.toString()
            tvDayOfWeek!!.text = formatDateToDayOfWeek(dataForeCast.datetime)

            lottieIcon!!.setAnimation(IconWeatherHelper.setIconWeather(dataForeCast.weather.code.toInt()))

            tempProcess!!.layoutParams.height = (dataForeCast.maxTemp - dataForeCast.minTemp).toInt() * 8
        }

    }

}