package com.elbarody.data.remote.datasource

import com.elbarody.data.model.ForecastResponse
import com.elbarody.data.remote.api.ForecastApi
import com.elbarody.data.remote.helper.apiCall
import com.elbarody.domin.helper.Response
import javax.inject.Inject

class ForecastDataSource @Inject constructor(
    private val api: ForecastApi
) : IForecastDataSource {
    override suspend fun getForecast(search: String): Response<ForecastResponse> = apiCall {
        api.getForecast(search = search)
    }
}