package org.creospace.compass

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import org.creospace.compass.presentation.MainNavGraph
import org.creospace.compass.theming.CompassTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {

    val navController = rememberNavController()

    CompassTheme {
        MainNavGraph(navController = navController)
    }
}