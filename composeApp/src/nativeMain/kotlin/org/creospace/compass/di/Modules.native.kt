package org.creospace.compass.di

import org.creospace.compass.data.room.CompassDatabase
import org.creospace.compass.data.room.getCompassDatabase
import org.creospace.compass.room.getDatabaseBuilder
import org.koin.dsl.module

actual val platformModule = module {
    single<CompassDatabase> {
        val builder = getDatabaseBuilder()
        getCompassDatabase(builder)
    }
}