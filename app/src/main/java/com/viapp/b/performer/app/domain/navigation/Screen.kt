package com.viapp.b.performer.app.domain.navigation

sealed class Screen(val route: String) {
    object GoalListScreen : Screen("goal_list")
    object SettingsScreen : Screen("settings")
}

