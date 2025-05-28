package org.creospace.compass

import android.content.Context

lateinit var audiPlayerContext: Context

fun initAudioPlayer(context: Context) {
    audiPlayerContext = context
}

actual fun getAudioPlayer(): AudioPlayer {
    return AudioPlayer(audiPlayerContext)
}