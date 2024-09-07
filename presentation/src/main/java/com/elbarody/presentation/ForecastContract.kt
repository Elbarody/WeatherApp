package com.elbarody.presentation

import androidx.compose.ui.text.input.TextFieldValue
import com.elbarody.base.mvi.UiEvent
import com.elbarody.base.mvi.UiState
import com.elbarody.domin.model.ForecastModel

class ForecastContract {

    sealed class Event : UiEvent {
        data class OnSearchChanged(val searchText: TextFieldValue) : Event()

    }

    data class State(
        val forecastState: ForecastUiState = ForecastUiState.Idle,
        val textSearch: TextFieldValue = TextFieldValue("")
    ) : UiState


    sealed class ForecastUiState {
        data object Idle : ForecastUiState()
        data class Loading(val isLoading: Boolean) : ForecastUiState()
        data class DisplayForecast(val forecast: ForecastModel) : ForecastUiState()
        data class DisplayError(val errorMessage: String? = null) : ForecastUiState()
    }
}