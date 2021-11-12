package com.viapp.b.performer.ui.entity

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
    val badgeCount: Int = 0,
)
