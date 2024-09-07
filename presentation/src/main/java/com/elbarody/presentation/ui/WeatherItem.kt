package com.elbarody.presentation.ui

import androidx.compose.foundation.Image
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.elbarody.base.utils.Dimens.threeLevelPadding
import com.elbarody.domin.model.ForecastHourItem
import com.elbarody.presentation.R

@Composable
fun WeatherItem(forecastHourItem: ForecastHourItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 3.dp)
            .shadow(1.dp, RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Time : " + forecastHourItem.date)
            Text(text = "Temperature : " + forecastHourItem.temp)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = stringResource(R.string.condition) + forecastHourItem.condition)
            Image(
                modifier = Modifier.size(40.dp),
                painter = rememberAsyncImagePainter(forecastHourItem.icon),
                contentDescription = null
            )
        }
    }
}
