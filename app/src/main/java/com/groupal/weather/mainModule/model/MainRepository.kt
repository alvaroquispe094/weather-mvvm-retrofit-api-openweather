package com.groupal.weather.mainModule.model

import com.groupal.weather.common.entities.WeatherForecastEntity

/****
 * Project: Weather
 * From: com.cursosandroidant.weather.mainModule.model
 * Created by Alain Nicolás Tello on 26/03/22 at 16:19
 * All rights reserved 2022.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
class MainRepository {
    private val remoteDatabase = RemoteDatabase()

    suspend fun getWeatherAndForecast(lat: Double, lon: Double, appId: String, exclude: String, units: String,
                                      lang: String) : WeatherForecastEntity =
     remoteDatabase.getWeatherForecastByCoordinates(lat, lon, appId, exclude, units, lang)
}