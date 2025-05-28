package org.creospace.compass.di

import org.creospace.compass.AudioPlayer
import org.creospace.compass.data.room.CompassDatabase
import org.creospace.compass.data.room.getCompassDatabase
import org.creospace.compass.getAudioPlayer
import org.creospace.compass.initAudioPlayer
import org.creospace.compass.room.getDatabaseBuilder
import org.koin.dsl.module

actual val platformModule = module {
    single<CompassDatabase> {
        val builder = getDatabaseBuilder(context = get())
        getCompassDatabase(builder)
    }
}