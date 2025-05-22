package org.creospace.compass.presentation.detail_journal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.creospace.compass.data.CompassRepository
import org.creospace.compass.data.Journal
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

sealed interface DetailUiState {
    data class Success(val detail: Journal) : DetailUiState
    object Error : DetailUiState
    object Loading : DetailUiState
}

class DetailJournalViewModel(
    private val repository: CompassRepository,
    val id: Long
) : ViewModel() {

    var detailUiState: DetailUiState by mutableStateOf(DetailUiState.Loading)
        private set

    init {
        getJournalDetail(id)
    }

    private fun getJournalDetail(id: Long) {
        viewModelScope.launch {
            repository.getJournalsById(id).map {
                it.isNotEmpty()
            }
        }
    }
}