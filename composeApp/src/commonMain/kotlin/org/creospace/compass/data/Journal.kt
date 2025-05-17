package org.creospace.compass.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "journal")
data class Journal(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val title: String,
    val description: String
)
