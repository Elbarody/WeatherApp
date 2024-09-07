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
import com.elbarody.presentation.R

@Composable
fun WeatherItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 3.dp)
            .shadow(1.dp, RoundedCornerShape(threeLevelPadding))
            .clip(RoundedCornerShape(threeLevelPadding))
    ){

        Row (modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = "Time : " +"00:00")
            Text(text = "Temperature :" +"27.9 C")
        }

        Row (modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = stringResource(R.string.condition) +"Clear")
            Image(modifier = Modifier.size(40.dp), painter = rememberAsyncImagePainter("https://cdn.weatherapi.com/weather/64x64/night/113.png"), contentDescription = null)
        }
    }
}