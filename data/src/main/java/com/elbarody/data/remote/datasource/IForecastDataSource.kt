package com.elbarody.data.remote.datasource

import com.elbarody.data.model.ForecastResponse
import com.elbarody.domin.helper.Response

interface IForecastDataSource {
    suspend fun getForecast(search: String): Response<ForecastResponse>
}