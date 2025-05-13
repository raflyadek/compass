package org.creospace.compass.presentation.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import org.creospace.compass.presentation.Screens
import org.creospace.compass.presentation.components.ItemJournal

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