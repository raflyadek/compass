package org.creospace.compass.di

import org.creospace.compass.data.CompassRepository
import org.creospace.compass.data.room.CompassDatabase
import org.creospace.compass.data.room.JournalDao
import org.creospace.compass.domain.CompassRepositoryImpl
import org.creospace.compass.presentation.create_journal.CreateJournalViewModel
import org.creospace.compass.presentation.main.MainViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single<JournalDao> { get<CompassDatabase>().getJournalDao() }
    single<CompassRepository> { CompassRepositoryImpl(get()) }
}

val viewModelModule = module {
    viewModelOf(::MainViewModel)
    viewModelOf(::CreateJournalViewModel)
}