package org.creospace.compass.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.creospace.compass.data.Journal
import org.creospace.compass.presentation.create_journal.CreateJournalScreen
import org.creospace.compass.presentation.detail_journal.DetailJournalScreen
import org.creospace.compass.presentation.main.MainScreen

@Composable
fun MainNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screens.Main.route) {
        val navigateToDetail: (Journal) -> Unit = { journal ->
            navController.navigate("DetailJournalScreen/${journal.id}")
        }
        composable(route = Screens.Main.route) {
            MainScreen(
                navController = navController,
                toDetail = navigateToDetail
            )
        }
        composable(route = Screens.CreateJournal.route) {
            CreateJournalScreen(navController = navController)
        }
        composable(route = Screens.DetailJournal.route) {
            DetailJournalScreen(navController = navController, journal = Journal())
        }
    }
}