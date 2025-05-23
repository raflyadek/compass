package org.creospace.compass.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import org.creospace.compass.data.Journal
import org.creospace.compass.presentation.create_journal.CreateJournalScreen
import org.creospace.compass.presentation.detail_journal.DetailJournalScreen
import org.creospace.compass.presentation.detail_journal.DetailJournalViewModel
import org.creospace.compass.presentation.main.MainScreen
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.component.getScopeId
import org.koin.core.parameter.parametersOf

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
        composable(
            route = "DetailJournalScreen/{id}",
            arguments = listOf(navArgument("id") { type = NavType.LongType })
        ) {
            val route = it.destination.route
            val id = route?.substringAfter("DetailJournalScreen/")?.toLongOrNull() ?: return@composable
            val detailJournalViewModel = koinViewModel<DetailJournalViewModel>(parameters = { parametersOf(id) })
            DetailJournalScreen(
                navController = navController,
                id = id
            )
        }
    }
}