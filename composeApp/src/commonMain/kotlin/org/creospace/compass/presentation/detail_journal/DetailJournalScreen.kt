package org.creospace.compass.presentation.detail_journal

import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.creospace.compass.data.Journal
import org.creospace.compass.presentation.Screens
import org.creospace.compass.presentation.components.CompassAppBar
import org.creospace.compass.presentation.components.Spacer
import org.creospace.compass.presentation.components.TextMedium
import org.creospace.compass.presentation.components.TextRegular
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DetailJournalScreen(
    modifier: Modifier = Modifier,
    viewModel: DetailJournalViewModel = koinViewModel(),
    id: Long,
    navController: NavController
) {

    val journal by viewModel.getDetailById(id).collectAsState()
    Scaffold(
        topBar = {
            CompassAppBar(
                title = Screens.DetailJournal.title,
                onBackClick = { navController.popBackStack() },
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            DetailJournalScreenContent(journal = journal!!)
        }
    }
}

@Composable
fun DetailJournalScreenContent(modifier: Modifier = Modifier, journal: Journal) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TextMedium(
            text = journal.title.orEmpty() ,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(margin = 10.dp)

        TextRegular(
            text = journal.description.orEmpty()
        )
    }
}