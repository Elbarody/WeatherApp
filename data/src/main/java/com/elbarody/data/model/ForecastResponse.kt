package com.elbarody.data.model

import com.google.gson.annotations.SerializedName

data class ForecastResponse(
    @SerializedName("location") val location: ForecastLocation,
    @SerializedName("current") val current: ForecastCurrent,
    @SerializedName("forecast") val forecast: Forecast
)

data class Forecast(
    @SerializedName("forecastday") val forecastDays: List<ForecastDay>
)

data class ForecastDay(
    @SerializedName("day") val day: ForecastDayDetails,
    @SerializedName("astro") val astro: ForecastAstro,
    @SerializedName("hour") val hours: List<ForecastHour>
)

data class ForecastHour(
    @SerializedName("time") val time: String,
    @SerializedName("temp_c") val temperature: Double,
    @SerializedName("condition") val condition: ForecastCondition
)

data class ForecastAstro(
    @SerializedName("sunrise") val sunrise: String, @SerializedName("sunset") val sunset: String
)

data class ForecastDayDetails(
    @SerializedName("maxtemp_c") val maxTemperature: Double,
    @SerializedName("mintemp_c") val minTemperature: Double,
)

data class ForecastCurrent(
    @SerializedName("temp_c") val temperature: Double,
    @SerializedName("condition") val condition: ForecastCondition

)

data class ForecastCondition(
    @SerializedName("text") val text: String, @SerializedName("icon") val iconUrl: String
) {
    val icon: String
        get() = "https:$iconUrl"
}

data class ForecastLocation(
    @SerializedName("name") val name: String,
    @SerializedName("country") val country: String,
    @SerializedName("localtime") val localTime: String
)
