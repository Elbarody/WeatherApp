package com.elbarody.domin.model

data class ForecastModel(
    val country: String,
    val city: String,
    val date: String,
    val maxTemp: String,
    val minTemp: String,
    val condition: String,
    val icon: String,
    val currentTemp: String,
    val sunrise: String,
    val sunset: String,
    val forecastHoursList: List<ForecastHourItem>

)

data class ForecastHourItem(
    val date: String,
    val temp: String,
    val condition: String,
    val icon: String
)
