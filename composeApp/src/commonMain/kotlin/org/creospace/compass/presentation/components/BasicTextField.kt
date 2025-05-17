package org.creospace.compass.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun BasicTextField(
    modifier: Modifier,
    label: String,
    singleLine: Boolean = true,
    value: (String) -> Unit
) {
    var textFieldDataMain by remember { mutableStateOf("") }

    OutlinedTextField(
        value = textFieldDataMain,
        onValueChange = {
            textFieldDataMain = it
            value(it)
        },
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium
            )
        },
        singleLine = singleLine,
        modifier = modifier
    )
}