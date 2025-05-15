package org.creospace.compass.di

import org.creospace.compass.data.room.CompassDatabase
import org.creospace.compass.data.room.getCompassDatabase
import org.creospace.compass.room.getDatabaseBuilder
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformModule = module {
    singleOf(::DbClient)
    single<CompassDatabase> {
        val builder = getDatabaseBuilder()
        getCompassDatabase(builder)
    }
}