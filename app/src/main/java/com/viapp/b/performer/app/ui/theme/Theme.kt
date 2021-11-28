package com.viapp.b.performer.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    //background
    primary = AppColor.primaryDark,
    secondary = AppColor.secondaryDark,
    onPrimary = AppColor.accent,

)

private val LightColorPalette = lightColors(
    primary = AppColor.primaryLight,
    secondary = AppColor.secondaryLight,
    onPrimary = AppColor.accent,
)

@Composable
fun PerformerTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = AppShape.default,
        content = content
    )
}