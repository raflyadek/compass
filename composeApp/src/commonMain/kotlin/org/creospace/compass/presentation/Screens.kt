package org.creospace.compass.presentation

sealed class Screens(val route: String, val title: String) {
    data object Main: Screens(route = "MainScreen", title = "Main")
    data object CreateJournal: Screens(route = "CreateJournalScreen", title = "Create Journal")
    data object DetailJournal: Screens(route = "DetailJournalScreen", title = "Detail Journal")
}