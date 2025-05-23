package org.creospace.compass.data

import kotlinx.coroutines.flow.Flow
import org.creospace.compass.data.room.JournalDao

interface CompassRepository {
    fun getJournals(): Flow<List<Journal>>
    fun getJournalsById(id: Long): Flow<Journal>
    suspend fun insertJournal(journal: Journal)
    suspend fun deleteJournal(journal: Journal)
    suspend fun updateJournal(journal: Journal)
}