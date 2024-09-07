package com.elbarody.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import com.elbarody.base.compose.AppScaffold
import com.elbarody.base.compose.ShowUserMessage
import com.elbarody.base.compose.SmallCenteredCircularProgressIndicator
import com.elbarody.base.utils.Dimens
import com.elbarody.domin.model.ForecastModel
import com.elbarody.presentation.ForecastContract
import com.elbarody.presentation.ForecastWithSearchViewModel
import com.elbarody.presentation.R

@Composable
fun ForecastWithSearchScreen(
    viewModel: ForecastWithSearchViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val isDataLoaded = uiState.forecastState is ForecastContract.ForecastUiState.DisplayForecast


    when (val state = uiState.forecastState) {
        is ForecastContract.ForecastUiState.Loading -> {
            SmallCenteredCircularProgressIndicator()
        }

        is ForecastContract.ForecastUiState.DisplayError -> ShowUserMessage(
            message = state.errorMessage ?: ""
        )

        is ForecastContract.ForecastUiState.DisplayForecast -> {
        }

        is ForecastContract.ForecastUiState.Idle -> {}

    }

    AppScaffold(modifier = Modifier
        .padding(Dimens.fourLevelPadding)
        .fillMaxWidth(), topBar = {
        SearchTopBar(changedTextField = uiState.textSearch, onTextChanged = {
            viewModel.handleEvent(ForecastContract.Event.OnSearchChanged(it))
        })
    }) {
        if (isDataLoaded) {
            val forecastModel = (uiState.forecastState as? ForecastContract.ForecastUiState.DisplayForecast)?.forecast
            val forecastHourList = forecastModel?.forecastHoursList ?: emptyList()

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(it)
            ) {
                forecastModel?.let {forecastModel ->
                    GeneralWeatherItem(forecastModel = forecastModel)
                }
                LazyColumn {
                    items(forecastHourList) { forecastHourItem ->
                        WeatherItem(forecastHourItem = forecastHourItem)
                    }
                }

            }
        }

    }

}

@Composable
fun GeneralWeatherItem(forecastModel: ForecastModel) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = stringResource(R.string.country_name) + forecastModel.country)
            Text(text = stringResource(R.string.city_name) + forecastModel.city)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Current Weather")
            Text(text = forecastModel.date)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(R.string.current_temp) + forecastModel.currentTemp
            )
            Text(text = stringResource(R.string.condition) + forecastModel.condition)
            Image(
                painter = rememberAsyncImagePainter(forecastModel.icon), contentDescription = null
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = stringResource(R.string.max_temp) + forecastModel.maxTemp)
            Text(text = stringResource(R.string.min_temp) + forecastModel.minTemp)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = stringResource(R.string.sunrise) + forecastModel.sunrise)
            Text(text = stringResource(R.string.sunset) + forecastModel.sunset)
        }
    }
}


@Composable
@Preview
fun ForecastWithSearchScreenPreview() {
    ForecastWithSearchScreen()
}



