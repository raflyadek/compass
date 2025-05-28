package org.creospace.compass.presentation.music

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import org.creospace.compass.AudioPlayer
import org.creospace.compass.getAudioPlayer

@Composable
fun MusicScreen(navController: NavController) {

    val audioPlayer = remember { getAudioPlayer() }

    Button(
        onClick = {
            audioPlayer.playSound(0)
        }
    ) {
        Text(
            text = "Play"
        )
    }
}