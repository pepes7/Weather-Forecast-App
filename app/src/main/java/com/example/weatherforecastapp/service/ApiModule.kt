package com.example.weatherforecastapp.service

import com.example.weatherforecastapp.ApiService
import com.example.weatherforecastapp.ApiWoeid
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiModule {
}

fun client()= OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
    .readTimeout(10, TimeUnit.SECONDS)
    .addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    })
    .build()

fun gson(): Gson = GsonBuilder().create()

fun retrofit(url: String): Retrofit = Retrofit.Builder().baseUrl(url)
    .client(client())
    .addConverterFactory(GsonConverterFactory.create(gson()))
    .build()


fun apiService(): ApiService = retrofit("https://api.hgbrasil.com/").create(ApiService::class.java)

fun apiWoeid (): ApiWoeid = retrofit("https://api.hgbrasil.com/stats/").create(ApiWoeid::class.java)


