package com.viapp.b.performer.app.domain.navigation

import androidx.navigation.NavController
import com.viapp.b.domain.navigation.Router

class AndroidRouter(
    private val navController: NavController,
) : Router {

    override fun openTaskCreationScreen() {
        navController.navigate(Screen.GoalEditScreen.route)
    }
}