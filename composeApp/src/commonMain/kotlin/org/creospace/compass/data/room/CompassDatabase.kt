package org.creospace.compass.data.room

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import org.creospace.compass.data.Journal

@Database(entities = [Journal::class], version = 3, exportSchema = false)
@ConstructedBy(CompassDatabaseConstructor::class)
abstract class CompassDatabase : RoomDatabase() {
    abstract fun getJournalDao(): JournalDao
}

// Room compiler generates the `actual` implementations
@Suppress("NO_ACTUAL_FOR_EXPECT", "EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect object CompassDatabaseConstructor : RoomDatabaseConstructor<CompassDatabase> {
    override fun initialize(): CompassDatabase
}