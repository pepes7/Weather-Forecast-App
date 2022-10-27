package com.example.weatherforecastapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("weather")
    fun searchWeather(@Query("woeid")woeid : String): Call<Wheater>
}

interface ApiWoeid {
    @GET("find_woeid?key=17284dd0&format=json-cors&sdk_version=console")
    fun searchWeather(@Query("city_name")city_name : String): Call<Woeid>
}