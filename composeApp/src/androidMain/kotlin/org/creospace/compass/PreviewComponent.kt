package org.creospace.compass

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.creospace.compass.presentation.components.BasicTextField
import org.creospace.compass.presentation.components.ItemJournal


@Preview(showBackground = true)
@Composable
fun Preview_Internal() {
    Column(modifier = Modifier.fillMaxSize()) {
        ItemJournal(title = "title", description = "description", toDetail = {})
        BasicTextField(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            label = "Label"
        ) {

        }
    }
}