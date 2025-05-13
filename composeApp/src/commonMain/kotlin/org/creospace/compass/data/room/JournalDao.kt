package org.creospace.compass.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import org.creospace.compass.data.Journal

@Dao
interface JournalDao {
    @Query("SELECT * FROM journal")
    fun getJournals(): Flow<List<Journal>>

    @Insert
    suspend fun insert(journal: Journal)
}