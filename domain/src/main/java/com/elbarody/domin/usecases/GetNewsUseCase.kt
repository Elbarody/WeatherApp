package com.elbarody.domin.usecases

import com.elbarody.domin.repository.IForecastRepository
import javax.inject.Inject

class GetForecastUseCase @Inject constructor(private val repository: IForecastRepository) {

    suspend operator fun invoke(search: String) = repository.getForecast(search)
}