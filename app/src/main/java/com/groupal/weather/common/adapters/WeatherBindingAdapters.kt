package com.groupal.weather.common.adapters

import android.view.View
import androidx.databinding.BindingAdapter

/****
 * Project: Weather
 * From: com.cursosandroidant.weather.common.adapters
 * Created by Alain Nicolás Tello on 28/03/22 at 17:00
 * All rights reserved 2022.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean){
    view.visibility = if (isGone) View.GONE else View.VISIBLE
}