package org.creospace.compass.domain

import kotlinx.coroutines.flow.Flow
import org.creospace.compass.data.CompassRepository
import org.creospace.compass.data.Journal
import org.creospace.compass.data.room.JournalDao

class CompassRepositoryImpl(
    private val dao: JournalDao
) : CompassRepository {

    override fun getJournals(): Flow<List<Journal>> {
        return dao.getJournals()
    }

    override suspend fun insertJournal(journal: Journal) {
        dao.insert(journal)
    }

}