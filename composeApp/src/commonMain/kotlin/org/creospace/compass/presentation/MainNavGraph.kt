package org.creospace.compass.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import org.creospace.compass.presentation.create_journal.CreateJournalScreen
import org.creospace.compass.presentation.detail_journal.DetailJournalScreen
import org.creospace.compass.presentation.main.MainScreen

@Composable
fun MainNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screens.Main.route,
    ) {
        composable(route = Screens.Main.route) {
            MainScreen(
                navController = navController,
                toDetail = {
                    navController.navigate(Screens.DetailJournal(journalId = it.id))
                },
            )
        }
        composable(route = Screens.CreateJournal.route) {
            CreateJournalScreen(navController = navController)
        }
        composable<Screens.DetailJournal> { backStackEntry ->
            val journalId: Screens.DetailJournal = backStackEntry.toRoute()
            DetailJournalScreen(
                navController = navController,
                id = journalId.journalId
            )
        }
    }
}