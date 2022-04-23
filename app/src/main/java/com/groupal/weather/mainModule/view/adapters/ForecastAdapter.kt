package com.groupal.weather.mainModule.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.groupal.weather.BR
import com.groupal.weather.R
import com.groupal.weather.common.entities.Forecast
import com.groupal.weather.databinding.ItemWeatherBinding

/****
 * Project: Weather
 * From: com.cursosandroidant.weather.mainModule.view.adapters
 * Created by Alain Nicolás Tello on 29/03/22 at 13:29
 * All rights reserved 2022.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
class ForecastAdapter(private val listener: OnClickListener) :
    ListAdapter<Forecast, RecyclerView.ViewHolder>(ForecastDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent,
            false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val forecast = getItem(position)

        with(holder as ViewHolder){
            holder.binding?.setVariable(BR.forecast, forecast)
            holder.binding?.executePendingBindings()

            setListener(forecast)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = DataBindingUtil.bind<ItemWeatherBinding>(view)

        fun setListener(forecast: Forecast){
            binding?.root?.setOnClickListener {
                listener.onClick(forecast)
            }
        }
    }

    class ForecastDiffCallback : DiffUtil.ItemCallback<Forecast>(){
        override fun areItemsTheSame(oldItem: Forecast, newItem: Forecast): Boolean = oldItem.dt == newItem.dt

        override fun areContentsTheSame(oldItem: Forecast, newItem: Forecast): Boolean = oldItem == newItem
    }
}