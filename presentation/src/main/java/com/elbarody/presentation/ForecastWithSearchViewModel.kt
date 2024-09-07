package com.elbarody.presentation

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.viewModelScope
import com.elbarody.base.mvi.BaseViewModel
import com.elbarody.domin.helper.Response
import com.elbarody.domin.usecases.GetForecastUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class ForecastWithSearchViewModel @Inject constructor(
    private val forecastUseCase: GetForecastUseCase
) : BaseViewModel<ForecastContract.Event, ForecastContract.State>() {

    private val searchTextFlow = MutableStateFlow("")
    private val debounceDuration = 500L // 500ms debounce duration

    override fun createInitialState(): ForecastContract.State {
        return ForecastContract.State(
            ForecastContract.ForecastUiState.Idle,
            textSearch = TextFieldValue("")
        )
    }

    init {
        viewModelScope.launch {
            searchTextFlow
                .debounce(debounceDuration)
                .collect { searchText ->
                    if (searchText.isNotEmpty()) {
                        getForecast(searchText)
                    } else {
                        setState { copy(forecastState = ForecastContract.ForecastUiState.Idle) }
                    }
                }
        }
    }

    override fun handleEvent(event: ForecastContract.Event) {
        when (event) {
            is ForecastContract.Event.OnSearchChanged -> {
                setState {
                    copy(
                        textSearch = event.searchText,
                    )
                }
                searchTextFlow.value = event.searchText.text
            }
        }
    }

    private fun getForecast(searchText: String) {
        viewModelScope.launch {
            kotlin.runCatching {
                setState { copy(forecastState = ForecastContract.ForecastUiState.Loading(true)) }
                forecastUseCase.invoke(searchText)
            }.onSuccess { response ->
                if (response is Response.Success) {
                    val forecastPresentation = response.data
                    setState {
                        copy(
                            forecastState = ForecastContract.ForecastUiState.DisplayForecast(forecastPresentation),
                        )
                    }
                } else if (response is Response.Error) {
                    setErrorState(response.errorMessage)
                }
            }.onFailure {
                setErrorState(it.message ?: "Error occurred, please try again")
            }
        }
    }

    private fun setErrorState(errorMessage: String) {
        setState { copy(forecastState = ForecastContract.ForecastUiState.DisplayError(errorMessage)) }
    }
}
