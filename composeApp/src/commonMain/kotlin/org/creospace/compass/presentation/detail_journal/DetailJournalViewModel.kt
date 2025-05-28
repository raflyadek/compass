package org.creospace.compass.presentation.detail_journal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.creospace.compass.data.CompassRepository
import org.creospace.compass.data.Journal
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class DetailJournalViewModel(
    private val repository: CompassRepository,
) : ViewModel() {


    fun getDetailById(id: Long): StateFlow<Journal?> {
        return repository
            .getJournalById(id)
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(1000), null)
    }

    fun deleteJournal(journal: Journal) {
        viewModelScope.launch {
            repository.deleteJournal(journal)
        }
    }

    fun updateJournal(journal: Journal) {
        viewModelScope.launch {
            repository.updateJournal(journal)
        }
    }

}
