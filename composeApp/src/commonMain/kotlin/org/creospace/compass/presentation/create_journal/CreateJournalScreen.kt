package org.creospace.compass.presentation.create_journal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.creospace.compass.data.Journal
import org.creospace.compass.presentation.components.BasicTextField
import org.creospace.compass.presentation.components.CompassButton
import org.creospace.compass.presentation.components.Spacer
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateJournalScreen(
    navController: NavController,
    viewModel: CreateJournalViewModel = koinViewModel()
) {

    var title = remember { "" }
    var description = remember { "" }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Create Journal")
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

            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                label = "Title",
                value = {
                    title = it
                }
            )

            Spacer(margin = 8.dp)

            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                label = "Description",
                singleLine = false,
                value = {
                    description = it
                }
            )

            Spacer(margin = 24.dp)

            CompassButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                title = "Create Journal",
                onClick = {
                    viewModel.insertJournal(
                        journal = Journal(title = title, description = description)
                    )
                    navController.popBackStack()
                }
            )
//            Button(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 16.dp),
//                onClick = {
//                    viewModel.insertJournal(
//                        journal = Journal(title = title, description = description)
//                    )
//                    navController.popBackStack()
//                }
//            ) {
//                Text(text = "Submit")
//            }
        }
    }
}