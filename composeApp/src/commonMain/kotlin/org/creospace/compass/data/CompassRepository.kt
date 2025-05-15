package org.creospace.compass.data

import kotlinx.coroutines.flow.Flow
import org.creospace.compass.data.room.JournalDao

interface CompassRepository {
    fun getJournals(): Flow<List<Journal>>
    suspend fun insertJournal(journal: Journal)
}