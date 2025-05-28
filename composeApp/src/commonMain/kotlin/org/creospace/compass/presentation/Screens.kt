package org.creospace.compass.presentation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screens(val route: String, val title: String) {
    data object Main: Screens(route = "MainScreen", title = "Main")
    data object CreateJournal: Screens(route = "CreateJournalScreen", title = "Create Journal")
    @Serializable data class DetailJournal(val journalId: Long): Screens(route = "DetailJournalScreen/$journalId", title = "Detail Journal")
    data object MusicScreen: Screens(route = "MusicScreen", title = "Music")
}