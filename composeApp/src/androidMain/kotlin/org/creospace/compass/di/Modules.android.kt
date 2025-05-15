package org.creospace.compass.di

import org.creospace.compass.data.room.CompassDatabase
import org.creospace.compass.data.room.getCompassDatabase
import org.creospace.compass.presentation.main.MyViewModel
import org.creospace.compass.room.getDatabaseBuilder
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformModule = module {
    singleOf(::DbClient)
    single<CompassDatabase> {
        val builder = getDatabaseBuilder(context = get())
        getCompassDatabase(builder)
    }
    viewModelOf(::MyViewModel)
}