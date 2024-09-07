package com.elbarody.data.remote.api

import com.elbarody.data.model.ForecastResponse
import com.elbarody.data.remote.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastApi {
    @GET("forecast.json")
    suspend fun getForecast(
        @Query("key") clientId: String = Constants.API_KEY,
        @Query("q") search: String,
        @Query("days") days: Int = 1
    ): ForecastResponse
}