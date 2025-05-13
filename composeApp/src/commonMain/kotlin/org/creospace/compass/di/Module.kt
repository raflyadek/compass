package org.creospace.compass.di

import org.creospace.compass.data.room.CompassDatabase
import org.creospace.compass.data.room.JournalDao
import org.koin.core.module.Module
import org.koin.dsl.module

fun commonModule(): Module = module {
    single<JournalDao> { get<CompassDatabase>().getJournalDao() }
}