package com.elbarody.data.repository

import com.elbarody.data.mapper.mapResponse
import com.elbarody.data.mapper.mapToForecastModel
import com.elbarody.data.remote.datasource.ForecastDataSource
import com.elbarody.domin.repository.IForecastRepository
import javax.inject.Inject

class ForecastRepository @Inject constructor(
    private val dataSource: ForecastDataSource
) : IForecastRepository {
    override suspend fun getForecast(search: String) =
        dataSource.getForecast(search).mapResponse { forecastResponse ->
            forecastResponse.mapToForecastModel()
        }

}