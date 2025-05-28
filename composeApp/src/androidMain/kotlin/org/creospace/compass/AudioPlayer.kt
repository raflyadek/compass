package org.creospace.compass

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import compass.composeapp.generated.resources.Res

actual class AudioPlayer(private val context: Context) {
    private val mediaPlayer = ExoPlayer.Builder(context).build()
    private val mediaItem = soundResList.map {
        MediaItem.fromUri(Res.getUri(it))
    }

    init {
        mediaPlayer.prepare()
    }

    actual fun playSound(id: Int) {
        mediaPlayer.setMediaItem(mediaItem[id])
        mediaPlayer.play()
    }

    actual fun release() {
        mediaPlayer.release()
    }
}