package com.groupal.weather.common.entities

/****
 * Project: Weather
 * From: com.cursosandroidant.weather.common
 * Created by Alain Nicolás Tello on 26/03/22 at 15:14
 * All rights reserved 2022.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
data class WeatherForecastEntity(
    val timezone: String, val current: Current, val hourly: List<Forecast>?)
