package org.creospace.compass.presentation.detail_journal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.creospace.compass.data.Journal
import org.creospace.compass.presentation.Screens
import org.creospace.compass.presentation.components.CompassAppBar
import org.creospace.compass.presentation.components.Spacer
import org.creospace.compass.presentation.components.TextMedium
import org.creospace.compass.presentation.components.TextRegular

@Composable
fun DetailJournalScreen(modifier: Modifier = Modifier, journal: Journal, navController: NavController) {
    Scaffold(
        topBar = {
            CompassAppBar(
                title = "Journal Details",
                onBackClick = { navController.popBackStack() },
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
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
}