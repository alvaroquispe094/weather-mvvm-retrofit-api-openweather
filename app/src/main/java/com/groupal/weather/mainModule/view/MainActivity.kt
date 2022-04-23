package com.groupal.weather.mainModule.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.groupal.weather.BR
import com.groupal.weather.R
import com.groupal.weather.common.entities.Forecast
import com.groupal.weather.common.utils.CommonUtils
import com.groupal.weather.databinding.ActivityMainBinding
import com.groupal.weather.mainModule.view.adapters.ForecastAdapter
import com.groupal.weather.mainModule.view.adapters.OnClickListener
import com.groupal.weather.mainModule.viewModel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

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

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ForecastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupViewModel()
        setupObservers()
        setupAdapter()
        setupRecyclerView()
    }

    private fun setupViewModel() {
        val vm: MainViewModel by viewModels()
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, vm)
    }

    private fun setupObservers() {
        binding.viewModel?.let {
            it.getSnackbarMsg().observe(this){ resMsg ->
                Snackbar.make(binding.root, resMsg, Snackbar.LENGTH_LONG).show()
            }
            it.getResult().observe(this){ result ->
                adapter.submitList(result.hourly)
            }
        }
    }

    private fun setupAdapter(){
        adapter = ForecastAdapter(this)
    }

    private fun setupRecyclerView(){
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
    }

    override fun onStart() {
        super.onStart()
//        Coordenadas para Buenos Aires, Argentina = -34.603814,-58.381578
        lifecycleScope.launch {
            binding.viewModel?.getWeatherAndForecast(-34.603814,-58.381578,
                "6a5c325c9265883997730d09be2328e8", "", "metric", "en")
        }
    }

    /*
    * OnClickListener
    * */
    override fun onClick(forecast: Forecast) {
        Snackbar.make(binding.root, CommonUtils.getFullDate(forecast.dt), Snackbar.LENGTH_LONG).show()
    }
}