package org.creospace.compass.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.creospace.compass.data.Journal
import org.creospace.compass.data.CompassRepository

class MainViewModel(
    private val repository: CompassRepository
) : ViewModel() {

    private val _journals = MutableStateFlow<List<Journal>>(emptyList())
    val journals: StateFlow<List<Journal>> get() = _journals

    init {
        observeJournals()
    }

    private fun observeJournals() {
        viewModelScope.launch {
            repository.getJournals().collect {
                _journals.value = it
            }
        }
    }
}