package org.creospace.compass

import androidx.compose.ui.window.ComposeUIViewController
import org.creospace.compass.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}