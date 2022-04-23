package com.groupal.weather.mainModule.view.adapters

import com.groupal.weather.common.entities.Forecast

/****
 * Project: Weather
 * From: com.cursosandroidant.weather.mainModule.view.adapters
 * Created by Alain Nicolás Tello on 29/03/22 at 13:32
 * All rights reserved 2022.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
interface OnClickListener {
    fun onClick(forecast: Forecast)
}