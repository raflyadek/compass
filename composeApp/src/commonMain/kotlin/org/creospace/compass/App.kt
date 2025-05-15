package org.creospace.compass

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import org.creospace.compass.presentation.MainNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {

    val navController = rememberNavController()

    MaterialTheme {
        MainNavGraph(navController = navController)
    }
}