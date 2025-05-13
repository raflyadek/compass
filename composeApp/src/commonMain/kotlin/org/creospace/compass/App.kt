package org.creospace.compass

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import compass.composeapp.generated.resources.Res
import compass.composeapp.generated.resources.compose_multiplatform
import org.creospace.compass.presentation.MainNavGraph
import org.creospace.compass.presentation.Screens

@Composable
@Preview
fun App() {

    val navController = rememberNavController()

    MaterialTheme {
        MainNavGraph(navController = navController)
    }
}