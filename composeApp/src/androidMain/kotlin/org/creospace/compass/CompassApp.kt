package org.creospace.compass

import android.app.Application
import org.creospace.compass.di.initKoin
import org.koin.android.ext.koin.androidContext

class CompassApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin(
            appDeclaration = { androidContext(this@CompassApp) }
        )
    }
}