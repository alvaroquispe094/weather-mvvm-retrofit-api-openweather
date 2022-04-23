package com.groupal.weather.common.dataAccess

import com.groupal.weather.common.entities.WeatherForecastEntity
import com.groupal.weather.common.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

/****
 * Project: Weather
 * From: com.cursosandroidant.weather.common.dataAccess
 * Created by Alain Nicolás Tello on 26/03/22 at 15:48
 * All rights reserved 2022.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
interface WeatherService {
    @GET(Constants.ONE_CALL_PATH)
    suspend fun getWeatherForecastByCoordinates(
        @Query(Constants.LATITUDE_PARAM) lat: Double,
        @Query(Constants.LONGITUDE_PARAM) lon: Double,
        @Query(Constants.APP_ID_PARAM) appId: String,
        @Query(Constants.EXCLUDE_PARAM) exclude: String,
        @Query(Constants.UNITS_PARAM) units: String,
        @Query(Constants.LANGUAGE_PARAM) lang: String
    ) : WeatherForecastEntity
}