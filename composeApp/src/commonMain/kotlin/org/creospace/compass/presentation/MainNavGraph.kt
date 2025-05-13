package org.creospace.compass.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MainNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "") {
        composable(route = Screens.Main.route) {
            MainScreen()
        }
        composable(route = Screens.CreateJournal.route) {
            CreateJournalScreen()
        }
    }
}