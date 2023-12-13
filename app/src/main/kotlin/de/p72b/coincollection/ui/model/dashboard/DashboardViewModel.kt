package de.p72b.coincollection.ui.model.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.p72b.coincollection.data.util.Status
import de.p72b.coincollection.usecase.GetCoinCollectionUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val getCoinCollectionUseCase: GetCoinCollectionUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<DashboardUIState>(DashboardUIState.Loading)
    val uiState: StateFlow<DashboardUIState> = _uiState

    init {
        viewModelScope.launch {
            val result = getCoinCollectionUseCase.invoke()
            when (result.status) {
                Status.SUCCESS -> {
                    result.data?.let {
                        updateUi(
                            DashboardUIState.DashboardData(
                                sum = it.size
                            )
                        )
                        return@launch
                    }
                    updateUi(DashboardUIState.Error)
                }

                Status.ERROR -> updateUi(DashboardUIState.Error)
            }
        }
    }

    private fun updateUi(uiState: DashboardUIState) {
        _uiState.value = uiState
    }
}

sealed interface DashboardUIState {
    data object Loading : DashboardUIState
    data class DashboardData(val sum: Int) : DashboardUIState
    data object Error : DashboardUIState
}