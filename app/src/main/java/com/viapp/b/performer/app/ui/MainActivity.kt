package com.viapp.b.performer.app.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.viapp.b.performer.app.BottomNavigationBar
import com.viapp.b.performer.app.base.BaseActivity
import com.viapp.b.performer.app.domain.navigation.Screen
import com.viapp.b.performer.app.ui.entity.NavigationItem
import com.viapp.b.performer.app.ui.screen.goalEdit.GoalEditScreenCompose
import com.viapp.b.performer.app.ui.screen.main.GoalListScreenCompose
import com.viapp.b.performer.app.ui.screen.main.SettingsScreenCompose
import org.koin.androidx.compose.getKoin

@ExperimentalMaterialApi
class MainActivity : BaseActivity() {

    @Preview(showBackground = true)
    @Composable
    override fun ShowContent() {
        val navController = rememberNavController()

        getKoin().setProperty("navController", navController)

        Scaffold(
            bottomBar = { MainBottomNavigationBar(navController = navController) },
            content = { paddingValues ->
                MainBottomNavigation(
                    navController = navController,
                    paddingValues = paddingValues,
                )
            }
        )
    }
}

@Composable
fun MainBottomNavigation(
    navController: NavHostController,
    paddingValues: PaddingValues,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.GoalListScreen.route,
        builder = {
            composable(
                route = Screen.GoalListScreen.route,
                content = { GoalListScreenCompose() },
            )
            composable(
                route = Screen.GoalEditScreen.route,
                content = { GoalEditScreenCompose() },
            )
            composable(
                route = Screen.SettingsScreen.route,
                content = { SettingsScreenCompose() },
            )

        },
        modifier = Modifier.padding(paddingValues = paddingValues),
    )
}

@ExperimentalMaterialApi
@Composable
fun MainBottomNavigationBar(
    navController: NavHostController,
) {
    BottomNavigationBar(
        navigationItems = listOf(
            NavigationItem(
                name = "goalList",
                route = Screen.GoalListScreen.route,
                icon = Icons.Default.Home
            ),
            NavigationItem(
                name = "settings",
                route = Screen.SettingsScreen.route,
                icon = Icons.Default.Settings
            ),
        ),
        navController = navController,
        onNavigationItemClick = {
            navController.navigate(it.route)
        }
    )
}