package org.creospace.compass.presentation.detail_journal

import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.creospace.compass.data.Journal
import org.creospace.compass.presentation.Screens
import org.creospace.compass.presentation.components.CompassAppBar
import org.creospace.compass.presentation.components.ExpandedFloatingActionButton
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
    println("TEST ID: $id")

    val detailFlow = remember(id) { viewModel.getDetailById(id) }
    val journal by detailFlow.collectAsState()

    Scaffold(
        floatingActionButton = {
            ExpandedFloatingActionButton(
                navController = navController,
                deleteClick = {
                    journal?.let { viewModel.deleteJournal(it) }
                    navController.popBackStack()
                }
            )
        },
        topBar = {
            CompassAppBar(
                title = journal?.title.orEmpty(),
                onBackClick = { navController.popBackStack() },
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            if (journal != null) {
                DetailJournalScreenContent(journal = journal)
            } else {
                Text("Loading...")
            }
        }
    }
}

@Composable
fun DetailJournalScreenContent(modifier: Modifier = Modifier, journal: Journal?) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = journal?.title.orEmpty(),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(6.dp)
        Text(
            text = journal?.description.orEmpty(),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}