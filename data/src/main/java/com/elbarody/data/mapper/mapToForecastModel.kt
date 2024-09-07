package com.elbarody.data.mapper

import com.elbarody.data.model.ForecastResponse
import com.elbarody.domin.model.ForecastHourItem
import com.elbarody.domin.model.ForecastModel

fun ForecastResponse.mapToForecastModel(): ForecastModel {
    val location = location
    val current = current
    val forecastDay = forecast.forecastDays.firstOrNull()
    val dayDetails = forecastDay?.day
    val astro = forecastDay?.astro

    val forecastHourItems = forecastDay?.hours?.map { hour ->
        ForecastHourItem(
            date = hour.time,
            temp = "${hour.temperature}°C",
            condition = hour.condition.text,
            icon = hour.condition.icon
        )
    } ?: emptyList()

    return ForecastModel(
        country = location.country,
        city = location.name,
        date = location.localTime,
        maxTemp = "${dayDetails?.maxTemperature ?: ""}°C",
        minTemp = "${dayDetails?.minTemperature ?: ""}°C",
        condition = current.condition.text,
        icon = current.condition.icon,
        currentTemp = "${current.temperature}°C",
        sunrise = astro?.sunrise ?: "",
        sunset = astro?.sunset ?: "",
        forecastHoursList = forecastHourItems
    )
}
