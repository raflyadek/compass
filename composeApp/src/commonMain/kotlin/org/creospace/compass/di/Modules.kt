package org.creospace.compass.di

import org.creospace.compass.data.MyRepository
import org.creospace.compass.data.MyRepositoryImpl
import org.creospace.compass.data.room.CompassDatabase
import org.creospace.compass.data.room.JournalDao
import org.creospace.compass.presentation.create_journal.CreateJournalViewModel
import org.creospace.compass.presentation.main.MyViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single<JournalDao> { get<CompassDatabase>().getJournalDao() }
    single<MyRepository> { MyRepositoryImpl(get()) }
    viewModelOf(::MyViewModel)
    viewModelOf(::CreateJournalViewModel)
}