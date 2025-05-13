package org.creospace.compass.presentation.create_journal

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun CreateJournalScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Create Journal")
                }
            )
        }
    ) {
        Text(
            text = "CreateJournalScreen",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxSize()
        )
    }
}