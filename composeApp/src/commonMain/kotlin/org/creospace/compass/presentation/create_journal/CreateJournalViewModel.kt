package org.creospace.compass.presentation.create_journal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.creospace.compass.data.Journal
import org.creospace.compass.data.MyRepository

class CreateJournalViewModel(private val repository: MyRepository) : ViewModel() {

    fun insertJournal(journal: Journal) {
        viewModelScope.launch {
            repository.insertJournal(journal)
        }
    }
}