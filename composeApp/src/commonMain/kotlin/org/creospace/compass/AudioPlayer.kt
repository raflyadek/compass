package org.creospace.compass

expect class AudioPlayer {
    fun playSound(id: Int)
    fun release()
}

val soundResList = listOf(
    "files/test_sound.mp4",
    "files/test_sounds.mp4",
)