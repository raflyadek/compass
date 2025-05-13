package org.creospace.compass

import org.creospace.compass.data.room.CompassDatabase
import org.creospace.compass.data.room.getCompassDatabase
import org.creospace.compass.room.getDatabaseBuilder
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single<CompassDatabase> {
        val builder = getDatabaseBuilder()
        getCompassDatabase(builder)
    }
}