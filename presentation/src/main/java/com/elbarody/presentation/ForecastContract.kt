package com.elbarody.presentation

import androidx.compose.ui.text.input.TextFieldValue
import com.elbarody.base.mvi.UiEvent
import com.elbarody.base.mvi.UiState

class ForecastContract {

    sealed class Event : UiEvent {
        data class OnSearchChanged(val newText: TextFieldValue) : Event()

    }

    data class ForecastUiState(
        val searchText: TextFieldValue = TextFieldValue(""),
        val errorMessage: String? = null
    ) : UiState
}