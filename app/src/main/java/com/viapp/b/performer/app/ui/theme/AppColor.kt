package com.viapp.b.performer.app.ui.theme

import androidx.compose.ui.graphics.Color

object AppColor {

    val primaryLight = Color(0xFF_FA_FA_FA)
    val primaryDark = Color(0xFF_05_05_05)

    val secondaryLight = Color(0xFF0288D1)
    val secondaryDark = Color(0xFF0288D1)//


    //blue amber
    val accent = Color(0xFFFFC107)
    val primaryText = Color(0xFF212121)
    val secondaryText = Color(0xFF757575)
    val icons = Color(0xFFFFFFFF)
    val divider = Color(0xFFBDBDBD)

    val text = Color.Black

    private val purple200 = Color(0xFFBB86FC)
    private val purple500 = Color(0xFF6200EE)
    private val purple700 = Color(0xFF3700B3)
    private val teal200 = Color(0xFF03DAC5)

    object Gradient {
        val default = listOf(
            icons,
            accent,
        )
    }
}