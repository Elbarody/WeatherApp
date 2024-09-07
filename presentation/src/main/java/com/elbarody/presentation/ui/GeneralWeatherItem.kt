package com.elbarody.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.elbarody.base.compose.annotatedString
import com.elbarody.base.utils.Dimens
import com.elbarody.domin.model.ForecastModel
import com.elbarody.presentation.R

@Composable
fun GeneralWeatherItem(forecastModel: ForecastModel) {
    Column(
        modifier = Modifier
            .padding(top = Dimens.threeLevelPadding)
            .fillMaxWidth()
            .background(
                color = Color.White, shape = RoundedCornerShape(size = Dimens.fourLevelPadding)
            )
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = RoundedCornerShape(size = Dimens.fourLevelPadding)
            )
            .padding(Dimens.twoLevelPadding),
        verticalArrangement = Arrangement.spacedBy(Dimens.twoLevelPadding)
    ) {
        // Country and City Row
        WeatherRowItem(
            annotatedString(stringResource(R.string.country_name), forecastModel.country),
            annotatedString(stringResource(R.string.city_name), forecastModel.city)
        )

        // Current Weather and Date Row
        WeatherRowItem(
            annotatedString(stringResource(R.string.current_weather), ""),
            annotatedString(forecastModel.date, "")
        )

        // Current Temp, Condition, and Icon Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(Dimens.oneLevelPadding)
            ) {
                Text(
                    text = annotatedString(
                        stringResource(R.string.current_temp), forecastModel.currentTemp
                    )
                )
                Text(
                    text = annotatedString(
                        stringResource(R.string.condition), forecastModel.condition
                    )
                )
            }

            Image(
                modifier = Modifier.size(70.dp),
                painter = rememberAsyncImagePainter(forecastModel.icon),
                contentDescription = null
            )
        }

        // Max Temp and Min Temp Row
        WeatherRowItem(
            annotatedString(stringResource(R.string.max_temp), forecastModel.maxTemp),
            annotatedString(stringResource(R.string.min_temp), forecastModel.minTemp)
        )

        // Sunrise and Sunset Row
        WeatherRowItem(
            annotatedString(stringResource(R.string.sunrise), forecastModel.sunrise),
            annotatedString(stringResource(R.string.sunset), forecastModel.sunset)
        )
    }
}