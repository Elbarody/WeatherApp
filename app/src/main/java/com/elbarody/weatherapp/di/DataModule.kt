package com.elbarody.weatherapp.di

import com.elbarody.data.remote.datasource.ForecastDataSource
import com.elbarody.data.remote.datasource.IForecastDataSource
import com.elbarody.data.repository.ForecastRepository
import com.elbarody.domin.repository.IForecastRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindForecastRepository(forecastRepository: ForecastRepository): IForecastRepository

    @Binds
    abstract fun bindForecastDataSource(forecastRepository: ForecastDataSource): IForecastDataSource
}