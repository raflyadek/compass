package org.creospace.compass.presentation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.creospace.compass.presentation.Screens
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = {
                    Text(text = "Create")
                },
                onClick = {
                    navController.navigate(Screens.CreateJournal.route)
                }
            )
        }
    ) {
        LazyColumn {
            items(20) {
                ItemJournal()
            }
        }
    }
}

@Preview
@Composable
fun ItemJournal() {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    ) {
        Column {
            Text("Title")
            Text("Description")
        }
    }
}