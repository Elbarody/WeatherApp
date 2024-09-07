package com.elbarody.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.elbarody.base.compose.AppScaffold
import com.elbarody.base.utils.Dimens
import com.elbarody.presentation.ForecastContract
import com.elbarody.presentation.ForecastWithSearchViewModel
import com.elbarody.presentation.R

@Composable
fun ForecastWithSearchScreen(
    viewModel: ForecastWithSearchViewModel = hiltViewModel()
) {
    val viewState by viewModel.uiState.collectAsState()

    AppScaffold(modifier = Modifier
        .padding(Dimens.fourLevelPadding)
        .fillMaxWidth(), topBar = {
        SearchTopBar(changedTextField = viewState.searchText, onTextChanged = {
            viewModel.handleEvent(ForecastContract.Event.OnSearchChanged(it))
        })
    }) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(it)) {
            GeneralWeatherItem()

            LazyColumn {
                items(10) {
                    WeatherItem()
                }
            }

        }

    }

}

@Composable
fun GeneralWeatherItem() {
    Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(text = stringResource(R.string.country_name) +"Egypt")
        Text(text = stringResource(R.string.city_name) +"Cairo")
    }

    Row (modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){
        Text("Current Weather")
        Text(text = "2024-09-07 01:30")
    }
    Row (modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(modifier = Modifier.weight(1f), text = stringResource(R.string.current_temp) +"28.2")
        Text(text = stringResource(R.string.condition) +"Clear")
        Image(painter = rememberAsyncImagePainter("https://cdn.weatherapi.com/weather/64x64/night/113.png"), contentDescription = null)
    }

    Row (modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(text = stringResource(R.string.max_temp) +"37.0")
        Text(text = stringResource(R.string.min_temp) +"25")
    }

    Row (modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(text = stringResource(R.string.sunrise) +"05:36 AM")
        Text(text = stringResource(R.string.sunset) +"06:10 PM")
    }
}

@Composable
@Preview
fun ForecastWithSearchScreenPreview() {
    ForecastWithSearchScreen()
}



