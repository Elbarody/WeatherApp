package com.elbarody.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.elbarody.base.compose.AppScaffold

@Composable
fun ForecastWithSearchScreen(){
    AppScaffold(topBar = {SearchTopBar()}) {
        LazyColumn {
            items(10) {
                WeatherItem()
            }
        }

    }

}

@Composable
fun WeatherItem() {

}

@Composable
fun SearchTopBar() {

}
