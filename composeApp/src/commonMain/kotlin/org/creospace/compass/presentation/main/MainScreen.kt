package org.creospace.compass.presentation.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import org.creospace.compass.presentation.Screens
import org.creospace.compass.presentation.components.ItemJournal
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel = koinViewModel()) {

    val journals by viewModel.journals.collectAsState()
    println("TEST: ${journals}")
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screens.CreateJournal.route)

                }
            ) {
                Text(text = "Create")
            }
        }
    ) {
        LazyColumn {
            items(journals) {
                ItemJournal()
            }
        }
    }
}