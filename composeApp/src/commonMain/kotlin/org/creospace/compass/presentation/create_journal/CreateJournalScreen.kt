package org.creospace.compass.presentation.create_journal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.creospace.compass.data.Journal
import org.creospace.compass.presentation.components.BasicTextField
import org.creospace.compass.presentation.components.Spacer
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CreateJournalScreen(
    navController: NavController,
    viewModel: CreateJournalViewModel = koinViewModel()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Create Journal")
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ) {
            Spacer(margin = 8.dp)
            BasicTextField(
                modifier = Modifier.fillMaxWidth(),
                label = "Title",
                value = {

                }
            )
            Spacer(margin = 8.dp)
            BasicTextField(
                modifier = Modifier.fillMaxWidth(),
                label = "Description",
                singleLine = false,
                value = {

                }
            )
            Spacer(margin = 24.dp)
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.insertJournal(
                        journal = Journal(title = "title", description = "description")
                    )
                    navController.popBackStack()
                }
            ) {
                Text(text = "Submit")
            }
        }
    }
}