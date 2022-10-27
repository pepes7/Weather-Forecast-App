package com.example.weatherforecastapp

data class Wheater (
    var results: Results,
)


data class Results (
    var city: String,
    var date: String,
    var description: String,
    var temp: String,
    var time: String,
    var forecast: ArrayList<Forecast>
)

data class Woeid (
    var name: String,
    var region: String,
    var woeid: String
)

data class Forecast (
    var date: String,
    var weekday: String,
    var max: String,
    var min: String,
)