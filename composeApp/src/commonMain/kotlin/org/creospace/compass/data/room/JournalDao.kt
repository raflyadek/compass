package org.creospace.compass.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.creospace.compass.data.Journal

@Dao
interface JournalDao {
    @Query("SELECT * FROM journal ORDER BY id DESC")
    fun getJournals(): Flow<List<Journal>>

    @Insert
    suspend fun insert(journal: Journal)

    @Query("SELECT * FROM journal WHERE id = :id")
    fun getJournalsById(id: Long): Flow<List<Journal>>

    @Delete
    suspend fun delete(journal: Journal)

    @Update
    suspend fun update(journal: Journal)
}