package com.groupal.weather.mainModule.model

import com.groupal.weather.common.dataAccess.WeatherService
import com.groupal.weather.common.entities.WeatherForecastEntity
import com.groupal.weather.common.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/****
 * Project: Weather
 * From: com.cursosandroidant.weather.mainModule.model
 * Created by Alain Nicolás Tello on 26/03/22 at 16:12
 * All rights reserved 2022.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
class RemoteDatabase {
    private val retrofit = Retrofit.Builder()
     .baseUrl(Constants.BASE_URL)
     .addConverterFactory(GsonConverterFactory.create())
     .build()
    private val service = retrofit.create(WeatherService::class.java)

    suspend fun getWeatherForecastByCoordinates(lat: Double, lon: Double, appId: String, exclude: String,
                                                units: String, lang: String) : WeatherForecastEntity =
     withContext(Dispatchers.IO){
        service.getWeatherForecastByCoordinates(lat, lon, appId, exclude, units, lang)
    }
}