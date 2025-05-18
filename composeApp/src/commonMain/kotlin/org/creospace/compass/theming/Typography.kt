package org.creospace.compass.theming

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import compass.composeapp.generated.resources.Poppins_Bold
import compass.composeapp.generated.resources.Poppins_Medium
import compass.composeapp.generated.resources.Poppins_Regular
import compass.composeapp.generated.resources.Poppins_SemiBold
import compass.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font


@Composable
fun CompssFont() {
    val poppinsFont = FontFamily(
        Font(Res.font.Poppins_Bold, FontWeight.Bold)
    )
}


@Composable
fun AppTypography(): Typography{
    val poppins = FontFamily(
        Font(Res.font.Poppins_Bold, FontWeight.Bold),
        Font(Res.font.Poppins_Regular, FontWeight.Normal),
        Font(Res.font.Poppins_Medium, FontWeight.Medium),
        Font(Res.font.Poppins_SemiBold, FontWeight.SemiBold),
    )

    return Typography(
        headlineLarge = TextStyle(
            fontFamily = poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),
        displaySmall = TextStyle(
            fontFamily = poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        ),
    )
}

