package org.creospace.compass.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.creospace.compass.data.Journal
import org.creospace.compass.presentation.Screens
import org.creospace.compass.presentation.detail_journal.DetailJournalViewModel
import org.creospace.compass.theming.primaryLight
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ExpandedFloatingActionButton(
    modifier: Modifier = Modifier,
    navController: NavController,
    deleteClick : () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf(
        MiniFabItems(
            Icons.Filled.Edit,
            "Edit",
            onClick = { navController.navigate(Screens.CreateJournal.route) }
        ),
        MiniFabItems(
            Icons.Filled.Delete,
            "Delete",
            onClick = {
                deleteClick()
                navController.popBackStack()
            }
        )
    )
    Column(horizontalAlignment = Alignment.End) {
        AnimatedVisibility(
            visible = expanded,
            enter = fadeIn() + slideInVertically(initialOffsetY = {it}),
            exit = fadeOut() + slideOutVertically(targetOffsetY = {it})
        ) {
            LazyColumn(Modifier.padding(bottom = 8.dp)) {
                items(items.size) {
                    ItemFloatingActionButton(icon = items[it].icon, title = items[it].title, onClick = items[it].onClick)
                    Spacer(8.dp)
                }
            }
        }
        val transition = updateTransition(targetState = expanded, label = "transition")
        val rotation by transition.animateFloat(label = "rotation") {
            if (it) 315f else 0f
        }

        FloatingActionButton(
            onClick = {expanded = !expanded},
            containerColor = primaryLight
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "",
                modifier = Modifier.rotate(rotation)
            )
        }
    }
}

@Composable
fun ItemFloatingActionButton(modifier: Modifier = Modifier, icon: ImageVector, title: String, onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        onClick = {
            onClick()
        },
    ) {
        Text(text = title)
        Icon(imageVector = icon, contentDescription = "")
    }
}
data class MiniFabItems(
    val icon: ImageVector,
    val title: String,
    val onClick: () -> Unit
)