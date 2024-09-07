package com.elbarody.domin.repository

import com.elbarody.domin.helper.Response
import com.elbarody.domin.model.ForecastModel

interface IForecastRepository {

    suspend fun getForecast(search: String): Response<ForecastModel>
}