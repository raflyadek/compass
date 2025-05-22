package org.creospace.compass.presentation.detail_journal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.creospace.compass.data.CompassRepository
import org.creospace.compass.data.Journal

//sealed interface DetailUiState{
//    data class Success(val detail: Journal) : DetailUiState
//    object Error : DetailUiState
//    object Loading : DetailUiState
//}
//
//class DetailJournalViewModel(
//    private val repository: CompassRepository,
//    val id: String
//) : ViewModel() {
//    var detailUiState: DetailUiState by mutableStateOf(DetailUiState.Loading)
//        private set
//
//    init {
//
//    }
//
//    private fun getJournalDetail(id: String) {
//
//    }
//}