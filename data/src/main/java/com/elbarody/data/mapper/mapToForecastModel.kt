package com.elbarody.data.mapper

import com.elbarody.data.model.ForecastResponse
import com.elbarody.data.remote.helper.formatTime
import com.elbarody.domin.model.ForecastHourItem
import com.elbarody.domin.model.ForecastModel
import kotlin.math.round

fun ForecastResponse.mapToForecastModel(): ForecastModel {
    val location = location
    val current = current
    val forecastDay = forecast.forecastDays.firstOrNull()
    val dayDetails = forecastDay?.day
    val astro = forecastDay?.astro

    val forecastHourItems = forecastDay?.hours?.map { hour ->
        ForecastHourItem(
            date = formatTime(hour.time),
            temp = "${roundToNearestInt(hour.temperature)}°C",
            condition = hour.condition.text,
            icon = hour.condition.icon
        )
    } ?: emptyList()

    return ForecastModel(
        country = location.country,
        city = location.name,
        date = location.localTime,
        maxTemp = "${roundToNearestInt(dayDetails?.maxTemperature ?: 0.0)}°C",
        minTemp = "${roundToNearestInt(dayDetails?.minTemperature ?: 0.0)}°C",
        condition = current.condition.text,
        icon = current.condition.icon,
        currentTemp = "${roundToNearestInt(current.temperature)}°C",
        sunrise = astro?.sunrise ?: "",
        sunset = astro?.sunset ?: "",
        forecastHoursList = forecastHourItems
    )
}

fun roundToNearestInt(value: Double): Int {
    return round(value).toInt()
}
