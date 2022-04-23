package com.groupal.weather.common.utils

import com.groupal.weather.common.entities.Weather
import java.text.SimpleDateFormat
import java.util.*

/****
 * Project: Weather
 * From: com.cursosandroidant.weather.common.utils
 * Created by Alain Nicolás Tello on 28/03/22 at 16:25
 * All rights reserved 2022.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
object CommonUtils {
 fun getHour(epoch: Long): String = getFormatedTime(epoch, "HH:mm")

 fun getFullDate(epoch: Long): String = getFormatedTime(epoch, "dd/MM/yy HH:mm")

 private fun getFormatedTime(epoch: Long, pattern: String): String {
  return SimpleDateFormat(pattern, Locale.getDefault()).format(epoch * 1_000)
 }

 fun getWeatherMain(weather: List<Weather>?): String{
  return if (weather != null && weather.isNotEmpty()) weather[0].main else "-"
 }

 fun getWeatherDescription(weather: List<Weather>?): String{
  return if (weather != null && weather.isNotEmpty()) weather[0].description else "-"
 }
}