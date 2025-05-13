package org.creospace.compass.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import org.creospace.compass.data.room.CompassDatabase

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<CompassDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("compass_database.db")

    return Room.databaseBuilder<CompassDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}