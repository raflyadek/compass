package org.creospace.compass.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.math.sin

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
            Text(text = label)
        },
        singleLine = singleLine,
        modifier = modifier
    )
}