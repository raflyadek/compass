package org.creospace.compass.data

import kotlinx.coroutines.flow.Flow
import org.creospace.compass.data.room.JournalDao

interface MyRepository {
    fun getJournals(): Flow<List<Journal>>
    suspend fun insertJournal(journal: Journal)
}

class MyRepositoryImpl(
    private val dao: JournalDao
) : MyRepository {

    override fun getJournals(): Flow<List<Journal>> {
        return dao.getJournals()
    }

    override suspend fun insertJournal(journal: Journal) {
        dao.insert(journal)
    }

}