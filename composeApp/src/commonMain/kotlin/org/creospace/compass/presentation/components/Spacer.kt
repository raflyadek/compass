package org.creospace.compass.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun Spacer(margin: Dp) {
    androidx.compose.foundation.layout.Spacer(modifier = Modifier.padding(margin))
}