package com.elbarody.presentation

import com.elbarody.base.mvi.BaseViewModel
import javax.inject.Inject

class ForecastWithSearchViewModel @Inject constructor() :
    BaseViewModel<ForecastContract.Event, ForecastContract.ForecastUiState>() {
    override fun createInitialState(): ForecastContract.ForecastUiState {
        return ForecastContract.ForecastUiState()
    }

    override fun handleEvent(event: ForecastContract.Event) {
        when (event) {
            is ForecastContract.Event.OnSearchChanged -> {
                setState { copy(searchText = event.newText) }
            }
        }
    }
}