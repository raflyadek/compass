package org.creospace.compass.presentation.edit_journal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.creospace.compass.data.Journal
import org.creospace.compass.presentation.Screens
import org.creospace.compass.presentation.components.BasicTextField
import org.creospace.compass.presentation.components.CompassAppBar
import org.creospace.compass.presentation.components.CompassButton
import org.creospace.compass.presentation.components.Spacer
import org.creospace.compass.presentation.create_journal.CreateJournalViewModel
import org.creospace.compass.presentation.detail_journal.DetailJournalViewModel
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditJournalScreen(
    navController: NavController,
    viewModel: DetailJournalViewModel = koinViewModel(),
    id: Long
) {

    val detailFlow = remember(id) { viewModel.getDetailById(id) }
    val journal by detailFlow.collectAsState()
    val journalTitle = journal?.title.orEmpty()
    val journalDescription = journal?.description.orEmpty()


    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    LaunchedEffect(journal) {
        title = journal?.title.orEmpty()
        description = journal?.description.orEmpty()
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CompassAppBar(
                title = "Edit Journal",
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            Spacer(margin = 8.dp)

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                label = { Text("title")},
                value = title,
                onValueChange = { title = it },
                singleLine = true,
            )

            Spacer(margin = 8.dp)

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                label = { Text("Description")},
                value = description,
                onValueChange = { description = it},
                singleLine = false,
            )

            Spacer(margin = 24.dp)

            CompassButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                title = "Edit Journal",
                onClick = {
                    journal?.let {
                        viewModel.updateJournal(
                            journal = Journal(
                                id = it.id,
                                title = title,
                                description = description
                            )
                        )
                        navController.popBackStack()
                    }
                }
            )
        }
    }
}