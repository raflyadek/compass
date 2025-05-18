package org.creospace.compass.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun TextMedium(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: Int = 14
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.displayMedium.copy(
            fontSize = fontSize.sp
        )
    )
}

@Composable
fun TextRegular(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: Int = 14
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.bodyMedium.copy(
            fontSize = fontSize.sp
        )
    )
}

@Composable
fun TextLight(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: Int = 12
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.labelSmall.copy(
            fontSize = fontSize.sp
        )
    )
}